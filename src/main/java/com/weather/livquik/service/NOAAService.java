package com.weather.livquik.service;

import com.weather.livquik.exception.NOAACommunicationException;
import com.weather.livquik.model.NOAAMethod;
import com.weather.livquik.model.soap.Dwml;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.Map;


@Slf4j
public abstract class NOAAService {

    public Dwml getData(NOAAMethod method) throws NOAACommunicationException {
        method.assertMethodValidity();

        String textResponse = getData(method.getMethodName(), method.getArguments());

        if(textResponse != null){
            JAXBContext jaxbContext;
            try
            {
                jaxbContext = JAXBContext.newInstance(Dwml.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                return (Dwml) jaxbUnmarshaller.unmarshal(new StringReader(textResponse));
            } catch (JAXBException e) {
                log.error("Error in xml parsing", e);
            }
        }
        return null;
    }

    protected abstract String getData(String methodName, Map<String, String> params) throws NOAACommunicationException;
}
