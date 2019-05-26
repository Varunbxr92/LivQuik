package com.weather.livquik.soap;

public class NDFDgenByDayLatLonList extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"listLatLon", "startDate", "numDays", "Unit", "format"};
        return orderedArgNames;
    }
}
