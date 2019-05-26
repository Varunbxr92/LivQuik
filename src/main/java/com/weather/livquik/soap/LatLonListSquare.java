package com.weather.livquik.soap;

public class LatLonListSquare extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"centerPointLat", "centerPointLon", "distanceLat", "distanceLon", "resolution"};
        return orderedArgNames;
    }
}
