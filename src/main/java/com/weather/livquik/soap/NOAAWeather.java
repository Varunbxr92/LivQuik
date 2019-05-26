package com.weather.livquik.soap;

import com.weather.livquik.Utility.Executable;
import com.weather.livquik.exception.NOAACommunicationException;
import com.weather.livquik.model.soap.Dwml;

public class NOAAWeather {
    public Dwml query(Executable executable) throws NOAACommunicationException {
        return executable.executeAndReturnData();
    }
}
