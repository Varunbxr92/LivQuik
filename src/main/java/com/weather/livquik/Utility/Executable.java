package com.weather.livquik.Utility;


import com.weather.livquik.exception.NOAACommunicationException;
import com.weather.livquik.model.soap.Dwml;

public interface Executable {

    public Dwml executeAndReturnData() throws NOAACommunicationException;
}
