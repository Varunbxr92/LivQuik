package com.weather.livquik.soap;


public class LatLonListLine extends NOAASOAPMethod{
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"endPoint1Lat", "endPoint1Lon", "endPoint2Lat", "endPoint2Lon"};
        return orderedArgNames;
    }
}
