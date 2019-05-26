package com.weather.livquik.model;



import com.weather.livquik.Utility.Executable;

import java.util.Map;


public abstract class NOAAMethod implements Executable {
    protected final Map<String, String> arguments;

    public NOAAMethod() {
        arguments = getArgumentsTemplate();
    }

    public abstract void assertMethodValidity();

    public String getMethodName(){
        return this.getClass().getSimpleName();
    }

    public Map<String, String> getArguments() {
        Map<String, String> clone = getArgumentsTemplate();
        clone.putAll(arguments);
        return clone;
    }

    public abstract void addArgument(String name, String value);

    protected abstract Map<String, String> getArgumentsTemplate();
}
