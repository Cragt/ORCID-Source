package org.orcid.core.common.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.orcid.core.common.manager.EmailDomainManager;
import org.orcid.persistence.dao.EmailDomainDao;
import org.orcid.persistence.jpa.entities.EmailDomainEntity;
import org.orcid.persistence.jpa.entities.EmailDomainEntity.DomainCategory;

import com.google.common.net.InternetDomainName;

public class EmailDomainManagerImpl implements EmailDomainManager {

    @Resource(name = "emailDomainDao")
    private EmailDomainDao emailDomainDao;

    @Resource(name = "emailDomainDaoReadOnly")
    private EmailDomainDao emailDomainDaoReadOnly;

    private void validateEmailDomain(String emailDomain) {
        if (emailDomain == null || emailDomain.isBlank()) {
            throw new IllegalArgumentException("Email Domain must not be empty");
        }
        if(!InternetDomainName.isValid(emailDomain)) {
            throw new IllegalArgumentException("Email Domain '" + emailDomain + "' is invalid");
        }
    }
    
    @Override
    public EmailDomainEntity createEmailDomain(String emailDomain, DomainCategory category) {        
        validateEmailDomain(emailDomain);
        if (category == null) {
            throw new IllegalArgumentException("Category must not be empty");
        }
        return emailDomainDao.createEmailDomain(emailDomain, category);
    }

    @Override
    public boolean updateCategory(long id, DomainCategory category) {
        if (category == null) {
            throw new IllegalArgumentException("Category must not be empty");
        }
        return emailDomainDao.updateCategory(id, category);
    }

    @Override
    public EmailDomainEntity findByEmailDoman(String emailDomain) {
        if (emailDomain == null || emailDomain.isBlank()) {
            throw new IllegalArgumentException("Email Domain must not be empty");
        }
        return emailDomainDaoReadOnly.findByEmailDoman(emailDomain);
    }

    @Override
    public List<EmailDomainEntity> findByCategory(DomainCategory category) {
        if (category == null) {
            throw new IllegalArgumentException("Category must not be empty");
        }
        return emailDomainDaoReadOnly.findByCategory(category);
    }

    @Override
    public EmailDomainEntity createOrUpdateEmailDomain(String emailDomain, String rorId) {
        EmailDomainEntity existingEntity = emailDomainDaoReadOnly.findByEmailDoman(emailDomain);
        if(existingEntity != null) {
            if(!rorId.equals(existingEntity.getRorId())) {
                emailDomainDao.updateRorId(existingEntity.getId(), rorId);
            }
        } else {
            return emailDomainDao.createEmailDomain(emailDomain, DomainCategory.PROFESSIONAL, rorId);
        }
        return existingEntity;
    }

}
