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
// Generated on: 2012.04.24 at 04:55:29 PM BST 
//

package org.orcid.jaxb.model.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}personal-details" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}biography" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}researcher-urls" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}contact-details" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}keywords" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}external-identifiers" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}affiliations" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}delegation" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}applications" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.orcid.org/ns/orcid}scope"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( propOrder = { "personalDetails", "biography", "researcherUrls", "contactDetails", "keywords", "externalIdentifiers", "delegation", "applications" })
public class OrcidBio implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "personal-details")
    protected PersonalDetails personalDetails;
    @XmlElement(name = "biography")
    protected Biography biography;
    @XmlElement(name = "researcher-urls")
    protected ResearcherUrls researcherUrls;
    @XmlElement(name = "contact-details")
    protected ContactDetails contactDetails;
    protected Keywords keywords;
    @XmlElement(name = "external-identifiers")
    protected ExternalIdentifiers externalIdentifiers;
    protected Delegation delegation;
    protected Applications applications;
    @XmlAttribute
    protected Scope scope;

    /**
     * Gets the value of the personalDetails property.
     * 
     * @return possible object is {@link PersonalDetails }
     * 
     */
    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    /**
     * Sets the value of the personalDetails property.
     * 
     * @param value
     *            allowed object is {@link PersonalDetails }
     * 
     */
    public void setPersonalDetails(PersonalDetails value) {
        this.personalDetails = value;
    }

    /**
     * Gets the value of the contactDetails property.
     * 
     * @return possible object is {@link ContactDetails }
     * 
     */
    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    /**
     * Sets the value of the contactDetails property.
     * 
     * @param value
     *            allowed object is {@link ContactDetails }
     * 
     */
    public void setContactDetails(ContactDetails value) {
        this.contactDetails = value;
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }

    public ResearcherUrls getResearcherUrls() {
        return researcherUrls;
    }

    public void setResearcherUrls(ResearcherUrls researcherUrls) {
        this.researcherUrls = researcherUrls;
    }

    /**
     * Gets the value of the keywords property.
     * 
     * @return possible object is {@link Keywords }
     * 
     */
    public Keywords getKeywords() {
        return keywords;
    }

    /**
     * Sets the value of the keywords property.
     * 
     * @param value
     *            allowed object is {@link Keywords }
     * 
     */
    public void setKeywords(Keywords value) {
        this.keywords = value;
    }

    /**
     * Gets the value of the externalIdentifiers property.
     * 
     * @return possible object is {@link ExternalIdentifiers }
     * 
     */
    public ExternalIdentifiers getExternalIdentifiers() {
        return externalIdentifiers;
    }

    /**
     * Sets the value of the externalIdentifiers property.
     * 
     * @param value
     *            allowed object is {@link ExternalIdentifiers }
     * 
     */
    public void setExternalIdentifiers(ExternalIdentifiers value) {
        this.externalIdentifiers = value;
    }

    /**
     * Gets the value of the delegation property.
     * 
     * @return possible object is {@link Delegation }
     * 
     */
    public Delegation getDelegation() {
        return delegation;
    }

    /**
     * Sets the value of the delegation property.
     * 
     * @param value
     *            allowed object is {@link Delegation }
     * 
     */
    public void setDelegation(Delegation value) {
        this.delegation = value;
    }

    /**
     * Gets the value of the applications property.
     * 
     * @return possible object is {@link Applications }
     * 
     */
    public Applications getApplications() {
        return applications;
    }

    /**
     * Sets the value of the applications property.
     * 
     * @param value
     *            allowed object is {@link Applications }
     * 
     */
    public void setApplications(Applications value) {
        this.applications = value;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return possible object is {@link Scope }
     * 
     */
    public Scope getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *            allowed object is {@link Scope }
     * 
     */
    public void setScope(Scope value) {
        this.scope = value;
    }

    public void downGradeToExternalIdentifiersOnly() {
        setContactDetails(null);
        setKeywords(null);
        setPersonalDetails(null);
        setScope(null);
        setBiography(null);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((applications == null) ? 0 : applications.hashCode());
        result = prime * result + ((biography == null) ? 0 : biography.hashCode());
        result = prime * result + ((contactDetails == null) ? 0 : contactDetails.hashCode());
        result = prime * result + ((delegation == null) ? 0 : delegation.hashCode());
        result = prime * result + ((externalIdentifiers == null) ? 0 : externalIdentifiers.hashCode());
        result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
        result = prime * result + ((personalDetails == null) ? 0 : personalDetails.hashCode());
        result = prime * result + ((researcherUrls == null) ? 0 : researcherUrls.hashCode());
        result = prime * result + ((scope == null) ? 0 : scope.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrcidBio other = (OrcidBio) obj;
        if (applications == null) {
            if (other.applications != null)
                return false;
        } else if (!applications.equals(other.applications))
            return false;
        if (biography == null) {
            if (other.biography != null)
                return false;
        } else if (!biography.equals(other.biography))
            return false;
        if (contactDetails == null) {
            if (other.contactDetails != null)
                return false;
        } else if (!contactDetails.equals(other.contactDetails))
            return false;
        if (delegation == null) {
            if (other.delegation != null)
                return false;
        } else if (!delegation.equals(other.delegation))
            return false;
        if (externalIdentifiers == null) {
            if (other.externalIdentifiers != null)
                return false;
        } else if (!externalIdentifiers.equals(other.externalIdentifiers))
            return false;
        if (keywords == null) {
            if (other.keywords != null)
                return false;
        } else if (!keywords.equals(other.keywords))
            return false;
        if (personalDetails == null) {
            if (other.personalDetails != null)
                return false;
        } else if (!personalDetails.equals(other.personalDetails))
            return false;
        if (researcherUrls == null) {
            if (other.researcherUrls != null)
                return false;
        } else if (!researcherUrls.equals(other.researcherUrls))
            return false;
        if (scope != other.scope)
            return false;
        return true;
    }

}
