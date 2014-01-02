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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}relevancy-score"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}orcid-profile"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "relevancyScore", "orcidProfile" })
@XmlRootElement(name = "orcid-search-result")
public class OrcidSearchResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @XmlElement(name = "relevancy-score", required = true)
    protected RelevancyScore relevancyScore;
    @XmlElement(name = "orcid-profile", required = true)
    protected OrcidProfile orcidProfile;

    /**
     * Gets the value of the relevancyScore property.
     * 
     * @return
     *     possible object is
     *     {@link RelevancyScore }
     *     
     */
    public RelevancyScore getRelevancyScore() {
        return relevancyScore;
    }

    /**
     * Sets the value of the relevancyScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelevancyScore }
     *     
     */
    public void setRelevancyScore(RelevancyScore value) {
        this.relevancyScore = value;
    }

    /**
     * Gets the value of the orcidProfile property.
     * 
     * @return
     *     possible object is
     *     {@link OrcidProfile }
     *     
     */
    public OrcidProfile getOrcidProfile() {
        return orcidProfile;
    }

    /**
     * Sets the value of the orcidProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrcidProfile }
     *     
     */
    public void setOrcidProfile(OrcidProfile value) {
        this.orcidProfile = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrcidSearchResult)) {
            return false;
        }

        OrcidSearchResult that = (OrcidSearchResult) o;

        if (orcidProfile != null ? !orcidProfile.equals(that.orcidProfile) : that.orcidProfile != null) {
            return false;
        }
        if (relevancyScore != null ? !relevancyScore.equals(that.relevancyScore) : that.relevancyScore != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = relevancyScore != null ? relevancyScore.hashCode() : 0;
        result = 31 * result + (orcidProfile != null ? orcidProfile.hashCode() : 0);
        return result;
    }
}
