package com.weather.livquik.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CityLongLati {

    String latLong;
    String cityName;
}
