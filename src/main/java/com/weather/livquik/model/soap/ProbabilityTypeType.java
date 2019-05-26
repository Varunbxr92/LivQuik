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
 * <p>Java class for probability-typeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="probability-typeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="nonexceedance"/>
 *     &lt;enumeration value="exceedance"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "probability-typeType")
@XmlEnum
public enum ProbabilityTypeType {

    @XmlEnumValue("nonexceedance")
    NONEXCEEDANCE("nonexceedance"),
    @XmlEnumValue("exceedance")
    EXCEEDANCE("exceedance");
    private final String value;

    ProbabilityTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProbabilityTypeType fromValue(String v) {
        for (ProbabilityTypeType c: ProbabilityTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
