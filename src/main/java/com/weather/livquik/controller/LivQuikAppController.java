package com.weather.livquik.controller;

import com.weather.livquik.exception.NOAACommunicationException;
import com.weather.livquik.model.CityLongLati;
import com.weather.livquik.model.NOAAMethod;
import com.weather.livquik.model.WeatherData;
import com.weather.livquik.model.soap.Dwml;
import com.weather.livquik.soap.LatLonListCityNames;
import com.weather.livquik.soap.NDFDgen;
import com.weather.livquik.soap.NOAAWeather;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Controller class to delegate the response to respective
 * API Calls
 * */

@RestController
public class LivQuikAppController {

    /**
     * This method returns the City and Location list
     * */
    @RequestMapping(value="/getCityAndLocation",produces={"application/json"},method= RequestMethod.GET)
    public CityLongLati getCityAndLocation(){
        Dwml cityData = null;
        CityLongLati cityLongLati;
        try{
            NOAAMethod noaaMethod = new LatLonListCityNames();
            noaaMethod.addArgument("displayLevel","1");
            NOAAWeather weather = new NOAAWeather();
            cityData = weather.query(noaaMethod);
            cityLongLati = new CityLongLati();
            cityLongLati.setCityNameList(cityData.getCityNameList());
            cityLongLati.setLatLongList(cityData.getLatLonList());
            return cityLongLati;
        }
        catch (NOAACommunicationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method to return the weather forecast, basis on city name, start date,
     * Number of days, for those many days
     * */

    @RequestMapping(value="/getWeatherForecast",produces={"application/json"},method= RequestMethod.GET)
    public WeatherData getWeatherForecast(@RequestParam("cityName") String cityName,@RequestParam("startDate") Date startDate,@RequestParam("numberOfDays") int numberOfDays){
        Dwml getWeatherData = null;
        WeatherData weatherData;
        try {
            NOAAMethod method = new NDFDgen();

            method.addArgument("latitude", "35.4");
            method.addArgument("longitude", "-97.6");
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Calendar c = Calendar.getInstance();
        String strDate = dateFormat.format(c.getTime());
        return strDate;
    }

    private static String addDays(Date date,int numOfDays){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, numOfDays);
        String strDate = dateFormat.format(c.getTime());
        return strDate;
    }

}
