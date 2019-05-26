package com.weather.livquik.soap;

public class NDFDgenByDay extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"latitude", "longitude", "startDate", "numDays", "Unit", "format"};
        return orderedArgNames;
    }
}
