package com.weather.livquik.soap;

public class LatLonListSubgrid extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"lowerLeftLatitude", "lowerLeftLongitude", "upperRightLatitude", "upperRightLongitude", "resolution"};
        return orderedArgNames;
    }
}
