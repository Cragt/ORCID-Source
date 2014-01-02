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
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}put-code" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}funding-agency" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}grant-external-identifier" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}grant-number" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}short-description" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}grant-date" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}grant-contributors" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}grant-sources" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.orcid.org/ns/orcid}visibility"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "fundingAgency", "grantExternalIdentifier", "grantNumber", "shortDescription", "grantDate", "grantContributors", "grantSources" })
@XmlRootElement(name = "orcid-grant")
public class OrcidGrant implements VisibilityType, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @XmlElement(name = "funding-agency")
    protected FundingAgency fundingAgency;
    @XmlElement(name = "grant-external-identifier")
    protected GrantExternalIdentifier grantExternalIdentifier;
    @XmlElement(name = "grant-number")
    protected GrantNumber grantNumber;
    @XmlElement(name = "short-description")
    protected String shortDescription;
    @XmlElement(name = "grant-date")
    protected GrantDate grantDate;
    @XmlElement(name = "grant-contributors")
    protected GrantContributors grantContributors;
    @XmlElement(name = "grant-sources")
    protected GrantSources grantSources;
    @XmlAttribute(name = "put-code")
    protected String putCode;
    @XmlAttribute
    protected Visibility visibility;

    /**
     * Gets the value of the putCode property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public String getPutCode() {
        return putCode;
    }

    /**
     * Sets the value of the putCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setPutCode(String value) {
        this.putCode = value;
    }

    /**
     * Gets the value of the fundingAgency property.
     * 
     * @return
     *     possible object is
     *     {@link FundingAgency }
     *     
     */
    public FundingAgency getFundingAgency() {
        return fundingAgency;
    }

    /**
     * Sets the value of the fundingAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link FundingAgency }
     *     
     */
    public void setFundingAgency(FundingAgency value) {
        this.fundingAgency = value;
    }

    /**
     * Gets the value of the grantExternalIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link GrantExternalIdentifier }
     *     
     */
    public GrantExternalIdentifier getGrantExternalIdentifier() {
        return grantExternalIdentifier;
    }

    /**
     * Sets the value of the grantExternalIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrantExternalIdentifier }
     *     
     */
    public void setGrantExternalIdentifier(GrantExternalIdentifier value) {
        this.grantExternalIdentifier = value;
    }

    /**
     * Gets the value of the grantNumber property.
     * 
     * @return
     *     possible object is
     *     {@link GrantNumber }
     *     
     */
    public GrantNumber getGrantNumber() {
        return grantNumber;
    }

    /**
     * Sets the value of the grantNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrantNumber }
     *     
     */
    public void setGrantNumber(GrantNumber value) {
        this.grantNumber = value;
    }

    /**
     * Gets the value of the shortDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the value of the shortDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortDescription(String value) {
        this.shortDescription = value;
    }

    /**
     * Gets the value of the grantDate property.
     * 
     * @return
     *     possible object is
     *     {@link GrantDate }
     *     
     */
    public GrantDate getGrantDate() {
        return grantDate;
    }

    /**
     * Sets the value of the grantDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrantDate }
     *     
     */
    public void setGrantDate(GrantDate value) {
        this.grantDate = value;
    }

    /**
     * Gets the value of the grantContributors property.
     * 
     * @return
     *     possible object is
     *     {@link GrantContributors }
     *     
     */
    public GrantContributors getGrantContributors() {
        return grantContributors;
    }

    /**
     * Sets the value of the grantContributors property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrantContributors }
     *     
     */
    public void setGrantContributors(GrantContributors value) {
        this.grantContributors = value;
    }

    /**
     * Gets the value of the grantSources property.
     * 
     * @return
     *     possible object is
     *     {@link GrantSources }
     *     
     */
    public GrantSources getGrantSources() {
        return grantSources;
    }

    /**
     * Sets the value of the grantSources property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrantSources }
     *     
     */
    public void setGrantSources(GrantSources value) {
        this.grantSources = value;
    }

    /**
     * Gets the value of the visibility property.
     * 
     * @return
     *     possible object is
     *     {@link Visibility }
     *     
     */
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     * Sets the value of the visibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Visibility }
     *     
     */
    public void setVisibility(Visibility value) {
        this.visibility = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrcidGrant)) {
            return false;
        }

        OrcidGrant that = (OrcidGrant) o;

        if (fundingAgency != null ? !fundingAgency.equals(that.fundingAgency) : that.fundingAgency != null) {
            return false;
        }
        if (grantContributors != null ? !grantContributors.equals(that.grantContributors) : that.grantContributors != null) {
            return false;
        }
        if (grantDate != null ? !grantDate.equals(that.grantDate) : that.grantDate != null) {
            return false;
        }
        if (grantExternalIdentifier != null ? !grantExternalIdentifier.equals(that.grantExternalIdentifier) : that.grantExternalIdentifier != null) {
            return false;
        }
        if (grantNumber != null ? !grantNumber.equals(that.grantNumber) : that.grantNumber != null) {
            return false;
        }
        if (grantSources != null ? !grantSources.equals(that.grantSources) : that.grantSources != null) {
            return false;
        }
        if (putCode != null ? !putCode.equals(that.putCode) : that.putCode != null) {
            return false;
        }
        if (shortDescription != null ? !shortDescription.equals(that.shortDescription) : that.shortDescription != null) {
            return false;
        }
        if (visibility != that.visibility) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = fundingAgency != null ? fundingAgency.hashCode() : 0;
        result = 31 * result + (grantExternalIdentifier != null ? grantExternalIdentifier.hashCode() : 0);
        result = 31 * result + (grantNumber != null ? grantNumber.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (grantDate != null ? grantDate.hashCode() : 0);
        result = 31 * result + (grantContributors != null ? grantContributors.hashCode() : 0);
        result = 31 * result + (grantSources != null ? grantSources.hashCode() : 0);
        result = 31 * result + (putCode != null ? putCode.hashCode() : 0);
        result = 31 * result + (visibility != null ? visibility.hashCode() : 0);
        return result;
    }
}
