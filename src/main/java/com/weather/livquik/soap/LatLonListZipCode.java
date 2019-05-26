package com.weather.livquik.soap;

public class LatLonListZipCode extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"zipCodeList"};
        return orderedArgNames;
    }
}
