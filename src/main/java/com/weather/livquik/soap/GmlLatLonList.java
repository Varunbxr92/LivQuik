package com.weather.livquik.soap;


 public class GmlLatLonList extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"listLatLon", "requestedTime", "featureType", "weatherParameters"};
        return orderedArgNames;
    }
}
