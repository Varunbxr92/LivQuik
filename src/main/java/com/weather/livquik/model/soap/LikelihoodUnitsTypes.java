//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.26 at 08:41:08 PM IST 
//


package com.weather.livquik.model.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for likelihoodUnitsTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="likelihoodUnitsTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="percent"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "likelihoodUnitsTypes")
@XmlEnum
public enum LikelihoodUnitsTypes {

    @XmlEnumValue("percent")
    PERCENT("percent");
    private final String value;

    LikelihoodUnitsTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LikelihoodUnitsTypes fromValue(String v) {
        for (LikelihoodUnitsTypes c: LikelihoodUnitsTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
