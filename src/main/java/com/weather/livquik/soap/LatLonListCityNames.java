package com.weather.livquik.soap;


public class LatLonListCityNames extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"displayLevel"};
        return orderedArgNames;
    }
}
