package com.weather.livquik.service;


import com.weather.livquik.exception.NOAACommunicationException;
import com.weather.livquik.model.NOAAMethod;
import com.weather.livquik.model.soap.Dwml;
import com.weather.livquik.soap.LatLonListCityNames;
import com.weather.livquik.soap.NDFDgen;
import com.weather.livquik.soap.NOAAWeather;
import lombok.Data;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.net.MalformedURLException;
import java.util.Map;

@Data
public class NOAASOAPService extends NOAAService {

    private String serviceEndpoint = "https://graphical.weather.gov:443/xml/SOAP_server/ndfdXMLserver.php";


    @Override
    protected String getData(String methodName, Map<String, String> params) throws NOAACommunicationException {
        SOAPClient client = new SOAPClient(serviceEndpoint);
        try {
            SOAPMessage message = client.getDataAsSOAPMessage(methodName, params);
            return NOAASOAPUtil.getSOAPMessageContentAsString(message);
        } catch (MalformedURLException e) {
            throw new NOAACommunicationException("Invalid protocol for endpoint: "+serviceEndpoint, e);
        } catch (SOAPException e) {
            throw new NOAACommunicationException("Unable to make SOAP request to "+serviceEndpoint+
                    ". Embedded exception has more details.", e);
        }
    }

    public static void main(String[] args) {
        NOAAMethod method = new NDFDgen();
        NOAAMethod noaaMethod = new LatLonListCityNames();
        noaaMethod.addArgument("displayLevel","1");

// Add SOAP method arguments
        method.addArgument("latitude", "35.4");
        method.addArgument("longitude", "-97.6");
        method.addArgument("product", "time-series");
        method.addArgument("startTime", "2013-09-20T00:00");
        method.addArgument("endTime", "2013-09-20T12:00");
        method.addArgument("Unit", "e");
        method.addArgument("weatherParameters", "maxt=true");

// Construct the invoker
        NOAAWeather weather = new NOAAWeather();

// Request for data :)
        Dwml data = null;
        Dwml cityData = null;
        try {
            data = weather.query(method);
            cityData = weather.query(noaaMethod);
        } catch (NOAACommunicationException e) {
            e.printStackTrace();
        }

        System.out.println(data);
        System.out.println("\n\n\n\n\n\n ---------->");
//        System.out.println(cityData);
    }
}
