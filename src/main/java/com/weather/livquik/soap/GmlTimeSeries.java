package com.weather.livquik.soap;

public class GmlTimeSeries extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"listLatLon", "startTime", "endTime", "compType", "featureType", "propertyName"};
        return orderedArgNames;
    }
}
