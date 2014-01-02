/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2013 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.09 at 01:52:56 PM BST 
//

package org.orcid.jaxb.model.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}affiliation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "affiliation" })
@XmlRootElement(name = "orcid-affiliations")
public class Affiliations implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    protected List<Affiliation> affiliation;

    /**
     * Gets the value of the affiliation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the affiliation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getAffiliation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Affiliation }
     * 
     * 
     */
    public List<Affiliation> getAffiliation() {
        if (affiliation == null) {
            affiliation = new ArrayList<Affiliation>();
        }
        return this.affiliation;
    }

    public List<Affiliation> getAffiliationsByType(AffiliationType affiliationType) {
        List<Affiliation> filteredAffilations = new ArrayList<Affiliation>();
        if (affiliation != null && affiliationType != null) {
            for (Affiliation aff : affiliation) {
                if (affiliationType.equals(aff.getType())) {
                    filteredAffilations.add(aff);
                }
            }
        }
        return filteredAffilations;
    }
    
    public Map<String, Affiliation> retrieveAffiliationAsMap() {
        Map<String, Affiliation> affMap = new HashMap<String, Affiliation>();
        if (affiliation != null) {
            for (Affiliation aff : affiliation) {
                affMap.put(aff.putCode, aff);
            }
        }
        return affMap;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Affiliations)) {
            return false;
        }

        Affiliations that = (Affiliations) o;

        if (affiliation != null ? !affiliation.equals(that.affiliation) : that.affiliation != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return affiliation != null ? affiliation.hashCode() : 0;
    }
}
