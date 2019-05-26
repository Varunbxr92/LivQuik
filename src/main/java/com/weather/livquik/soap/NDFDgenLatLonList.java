package com.weather.livquik.soap;


public class NDFDgenLatLonList extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"listLatLon", "product", "startTime", "endTime", "Unit", "weatherParameters"};
        return orderedArgNames;
    }
}
