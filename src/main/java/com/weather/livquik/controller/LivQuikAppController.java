package com.weather.livquik.controller;

import com.google.common.collect.Lists;
import com.weather.livquik.exception.NOAACommunicationException;
import com.weather.livquik.model.CityLongLati;
import com.weather.livquik.model.NOAAMethod;
import com.weather.livquik.model.WeatherData;
import com.weather.livquik.model.soap.Dwml;
import com.weather.livquik.soap.LatLonListCityNames;
import com.weather.livquik.soap.NDFDgen;
import com.weather.livquik.soap.NOAAWeather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Controller class to delegate the response to respective
 * API Calls
 * */

@RestController
@Slf4j
public class LivQuikAppController {


    private static final List<CityLongLati> CITY_LONG_LATIS = Collections.synchronizedList(Lists.newArrayList());

    /**
     * This method returns the City and Location list
     * */
    @RequestMapping(value="/getCityAndLocation",produces={"application/json"},method= RequestMethod.GET)
    public List<CityLongLati> getCityAndLocation(){
        Dwml cityData = null;
        try{
            if (CITY_LONG_LATIS.isEmpty()) {
                buildCityAndLatLong();
                return CITY_LONG_LATIS;
            } else {
                return CITY_LONG_LATIS;
            }
        }
        catch (Exception e) {
            log.error("Internal Server error", e);
        }
        return null;
    }

    /**
     * Method to return the weather forecast, basis on city name, start date,
     * Number of days, for those many days
     * */

    @RequestMapping(value="/getWeatherForecast",produces={"application/json"},method= RequestMethod.GET)
    public WeatherData getWeatherForecast(@RequestParam("cityName") String cityName, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @RequestParam("numberOfDays") int numberOfDays){
        Dwml getWeatherData = null;
        WeatherData weatherData;
        try {
            NOAAMethod method = new NDFDgen();

            String latLong = findLatLong(cityName);
            if (Objects.isNull(latLong)) {
                return null;
            }

            String []latLongArray = latLong.split(",");

            method.addArgument("latitude", latLongArray[0]);
            method.addArgument("longitude", latLongArray[1]);
            method.addArgument("product", "time-series");
            method.addArgument("startTime", convertDateToString(startDate));
            method.addArgument("endTime", addDays(startDate,numberOfDays));
            method.addArgument("Unit", "e");
            method.addArgument("weatherParameters", "maxt=true");

            NOAAWeather weather = new NOAAWeather();
            getWeatherData = weather.query(method);
            weatherData = new WeatherData();
            weatherData.setLocation(getWeatherData.getData().get(0).getLocation());
            weatherData.setMoreWeatherInformation(getWeatherData.getData().get(0).getMoreWeatherInformation());
            weatherData.setParameters(getWeatherData.getData().get(0).getParameters());
           return weatherData;

        }catch (NOAACommunicationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String convertDateToString(Date date){
        System.out.println(date);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        return dateFormat.format(c.getTime());
    }

    private static String addDays(Date date,int numOfDays){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, numOfDays);
        return dateFormat.format(c.getTime());
    }

    private static String findLatLong(String cityName) {
        if (CITY_LONG_LATIS.isEmpty()) {
            buildCityAndLatLong();
        }
        return CITY_LONG_LATIS
                .stream()
                .filter(cityLongLati -> cityLongLati.getCityName().startsWith(cityName))
                .findFirst()
                .map(CityLongLati::getLatLong)
                .orElse(null);
    }

    private static void buildCityAndLatLong() {
        try {
            NOAAMethod noaaMethod = new LatLonListCityNames();
            noaaMethod.addArgument("displayLevel","1");
            NOAAWeather weather = new NOAAWeather();
            Dwml cityData = weather.query(noaaMethod);
            String cityNames = cityData.getCityNameList();
            String latLongs = cityData.getLatLonList();
            String []cityNameList = cityNames.split("\\|");
            String []latLongList = latLongs.split(" ");
            if (cityNameList.length == latLongList.length) {
                for (int i = 0; i < cityNameList.length; i++) {
                    String city = cityNameList[i];
                    if (latLongList.length > i) {
                        String latLong = latLongList[i];
                        CityLongLati cityLongLati = CityLongLati.builder().cityName(city).latLong(latLong).build();
                        CITY_LONG_LATIS.add(cityLongLati);
                    }
                }
            }
        } catch (NOAACommunicationException e) {
            log.error("Error in fetch data ", e);
        }
    }

}
