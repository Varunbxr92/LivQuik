package com.weather.livquik.soap;


public class NDFDgen extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"latitude", "longitude", "product", "startTime", "endTime", "Unit", "weatherParameters"};
        return orderedArgNames;
    }
}
