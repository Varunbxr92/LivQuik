package com.weather.livquik.soap;



import com.weather.livquik.Utility.Assert;
import com.weather.livquik.exception.NOAACommunicationException;
import com.weather.livquik.model.NOAAMethod;
import com.weather.livquik.model.soap.Dwml;
import com.weather.livquik.service.NOAASOAPService;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public abstract class NOAASOAPMethod extends NOAAMethod {

    private NOAASOAPService service = new NOAASOAPService();

   @Override
    public void assertMethodValidity() {
        String[] orderedArgumentNames = getOrderedArgumentNames();
        int index = 0;

        Iterator<String> keyIter = arguments.keySet().iterator();
        while(keyIter.hasNext()){
            String key = keyIter.next();
            String value = arguments.get(key);
            Assert.notBlank(value, "Invalid method argument " + key +". Value can not be empty or null");
            Assert.isTrue(orderedArgumentNames[index].equals(key), "Invalid method argument order. Arguments must be in order " + Arrays.toString(orderedArgumentNames));
            index ++;
        }
    }

    @Override
    protected Map<String, String> getArgumentsTemplate(){
        String[] argumentNames = getOrderedArgumentNames();
        Map<String, String> arguments;
        if(argumentNames != null && argumentNames.length > 0){
            arguments = new LinkedHashMap<String, String>(argumentNames.length);
            for(String name : argumentNames){
                arguments.put(name, "");
            }
        }else {
            arguments = new LinkedHashMap<String, String>(0);
        }
        return arguments;
    }

    @Override
    public void addArgument(String name, String value) {
        Assert.notBlank(name, "Invalid argument name. Name can not be empty or null");
        Assert.notBlank(value, "Invalid argument " + name + ". Value can not be empty or null");
        Assert.isTrue(arguments.containsKey(name), "Invalid argument " + name + " for this method");
        arguments.put(name, value);
    }

    @Override
    public Dwml executeAndReturnData() throws NOAACommunicationException {
        return service.getData(this);
    }

    public void setService(NOAASOAPService service) {
        this.service = service;
    }

    public NOAASOAPService getService() {
        return service;
    }

    abstract protected String[] getOrderedArgumentNames();
}
