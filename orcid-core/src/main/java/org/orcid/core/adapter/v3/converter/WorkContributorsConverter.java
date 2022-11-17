package org.orcid.core.adapter.v3.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.orcid.core.contributors.roles.ContributorRoleConverter;
import org.orcid.core.contributors.roles.InvalidContributorRoleException;
import org.orcid.core.contributors.roles.credit.CreditRole;
import org.orcid.core.contributors.roles.works.LegacyWorkContributorRole;
import org.orcid.core.utils.JsonUtils;
import org.orcid.jaxb.model.v3.release.common.ContributorAttributes;
import org.orcid.jaxb.model.v3.release.record.WorkContributors;
import org.orcid.pojo.WorkContributorsList;
import org.orcid.pojo.ajaxForm.PojoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class WorkContributorsConverter extends BidirectionalConverter<WorkContributors, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkContributorsConverter.class);
	
    private ContributorRoleConverter roleConverter;

    public WorkContributorsConverter(ContributorRoleConverter roleConverter) {
        this.roleConverter = roleConverter;
    }

    @Override
    public String convertTo(WorkContributors source, Type<String> destinationType) {
        // convert role to db format
        source.getContributor().forEach(c -> {
            if (c.getContributorAttributes() != null && c.getContributorAttributes().getContributorRole() != null) {
                String providedRoleValue = c.getContributorAttributes().getContributorRole();
                String resolvedRoleValue = roleConverter.toDBRole(providedRoleValue);
                if (resolvedRoleValue == null) {
                    Map<String, String> exceptionParams = new HashMap<>();
                    exceptionParams.put("role", providedRoleValue);
                    
                    List<String> legalValues = new ArrayList<>();
                    for (LegacyWorkContributorRole role : LegacyWorkContributorRole.values()) {
                        legalValues.add(role.value());
                    }
                    for (CreditRole role : CreditRole.values()) {
                        legalValues.add(role.value());
                    }
                    exceptionParams.put("validRoles", legalValues.toString());
                    
                    throw new InvalidContributorRoleException(exceptionParams);
                }
                c.getContributorAttributes().setContributorRole(resolvedRoleValue);
            }
        });
        return JsonUtils.convertToJsonString(source);
    }

    @Override
    public WorkContributors convertFrom(String source, Type<WorkContributors> destinationType) {
        WorkContributors workContributors = JsonUtils.readObjectFromJsonString(source, WorkContributors.class);
        
        // convert role to API format
        workContributors.getContributor().forEach(c -> {
            // Set the credit name
            c.setCreditName((c.getCreditName() != null && PojoUtil.isEmpty(c.getCreditName().getContent())) ? null : c.getCreditName());
            
            // Set the contributor attributes
            if (c.getContributorAttributes() != null && c.getContributorAttributes().getContributorRole() != null) {
                c.getContributorAttributes().setContributorRole(roleConverter.toRoleValue(c.getContributorAttributes().getContributorRole()));
            }
        });
        return workContributors;
    }

    public List<WorkContributorsList> getContributorsList(String source) {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<WorkContributorsList> langList = new ArrayList<>();
        try {
            langList = objectMapper.readValue(source, new TypeReference<List<WorkContributorsList>>(){});
            for (WorkContributorsList workContributorsList : langList) {
                if (workContributorsList.getContributor() != null && workContributorsList.getContributor().getContributorAttributes() != null) {
                    ContributorAttributes ca = workContributorsList.getContributor().getContributorAttributes();
                    String providedRoleValue = ca.getContributorRole();
                    if (!PojoUtil.isEmpty(providedRoleValue)) {
                        ca.setContributorRole(roleConverter.toRoleValue(providedRoleValue));
                    }
                }
            }
        } catch (JsonProcessingException | IllegalArgumentException e) {
            return langList;
        } catch (Exception ioe) {
        	LOGGER.error("Unable to process contributors", ioe);
        	throw ioe;
        }
        return langList;
    }
}
