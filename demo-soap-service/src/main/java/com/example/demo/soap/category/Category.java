//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.30 at 09:29:37 PM IST 
//


package com.example.demo.soap.category;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for category.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="category">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DOMESTIC"/>
 *     &lt;enumeration value="INTERNATIONAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "category", namespace = "http://www.example.com/demo/soap/category")
@XmlEnum
public enum Category {

    DOMESTIC,
    INTERNATIONAL;

    public String value() {
        return name();
    }

    public static Category fromValue(String v) {
        return valueOf(v);
    }

}
