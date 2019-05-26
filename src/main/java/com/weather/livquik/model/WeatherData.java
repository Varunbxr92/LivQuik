package com.weather.livquik.model;

import com.weather.livquik.model.soap.LocationType;
import com.weather.livquik.model.soap.MoreWeatherInformationType;
import com.weather.livquik.model.soap.ParametersType;
import lombok.Data;

import java.util.List;

@Data
public class WeatherData {

    List<MoreWeatherInformationType> moreWeatherInformation;

    List<LocationType> location;

    List<ParametersType> parameters;
}
