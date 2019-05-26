package com.weather.livquik.service;

import javax.xml.soap.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


class SOAPClient {
    private final String endpoint;

    SOAPClient(String endpoint) {
        this.endpoint = endpoint;
    }

    SOAPMessage getDataAsSOAPMessage(String methodName, Map<String, String> args) throws MalformedURLException, SOAPException {
        // construct message
        SOAPMessage requestMessage = buildMessage(methodName, args);

        // connect to server and retrieve information
        SOAPMessage responseMessage = requestForData(requestMessage);

        return responseMessage;
    }

    private SOAPMessage requestForData(SOAPMessage message) throws SOAPException, MalformedURLException {
        SOAPConnectionFactory connectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = connectionFactory.createConnection();

        try{
            return connection.call(message, new URL(endpoint));
        }finally {
            connection.close();
        }
    }

    private SOAPMessage buildMessage(String methodName, Map<String, String> args) throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage message = messageFactory.createMessage();
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        SOAPBody body = envelope.getBody();
        Name bodyName = envelope.createName(methodName, "m", endpoint);
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
        for(String param : args.keySet()){
            Name name = envelope.createName(param);
            bodyElement.addChildElement(name).addTextNode(args.get(param));
        }
        message.saveChanges();
        return message;
    }

    String getEndpoint() {
        return endpoint;
    }
}
