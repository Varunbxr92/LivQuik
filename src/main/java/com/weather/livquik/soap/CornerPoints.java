package com.weather.livquik.soap;


public class CornerPoints extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"sector"};
        return orderedArgNames;
    }
}
