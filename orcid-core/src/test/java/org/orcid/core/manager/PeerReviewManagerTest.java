/**
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2014 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
package org.orcid.core.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.orcid.core.BaseTest;
import org.orcid.jaxb.model.common_rc3.Iso3166Country;
import org.orcid.jaxb.model.common_rc3.Organization;
import org.orcid.jaxb.model.common_rc3.OrganizationAddress;
import org.orcid.jaxb.model.common_rc3.Title;
import org.orcid.jaxb.model.common_rc3.Url;
import org.orcid.jaxb.model.common_rc3.Visibility;
import org.orcid.jaxb.model.record.summary_rc3.PeerReviewSummary;
import org.orcid.jaxb.model.record.summary_rc3.PeerReviews;
import org.orcid.jaxb.model.record_rc3.ExternalID;
import org.orcid.jaxb.model.record_rc3.ExternalIDs;
import org.orcid.jaxb.model.record_rc3.PeerReview;
import org.orcid.jaxb.model.record_rc3.PeerReviewType;
import org.orcid.jaxb.model.record_rc3.Relationship;
import org.orcid.jaxb.model.record_rc3.Role;
import org.orcid.persistence.dao.PeerReviewDao;
import org.orcid.persistence.jpa.entities.ClientDetailsEntity;
import org.orcid.persistence.jpa.entities.PeerReviewEntity;
import org.orcid.persistence.jpa.entities.SourceEntity;

public class PeerReviewManagerTest extends BaseTest {
    private static final List<String> DATA_FILES = Arrays.asList("/data/SecurityQuestionEntityData.xml", "/data/SourceClientDetailsEntityData.xml",
            "/data/ProfileEntityData.xml", "/data/ClientDetailsEntityData.xml");
    
    private static final String CLIENT_1_ID = "4444-4444-4444-4498";
    private String claimedOrcid = "0000-0000-0000-0002";
    private String unclaimedOrcid = "0000-0000-0000-0001";
    
    @Mock
    private SourceManager sourceManager;
    
    @Resource 
    private PeerReviewManager peerReviewManager;
    
    @Resource
    private PeerReviewDao peerReviewDao;
    
    @BeforeClass
    public static void initDBUnitData() throws Exception {
        initDBUnitData(DATA_FILES);
    }

    @Before
    public void before() {
        peerReviewManager.setSourceManager(sourceManager);
    }
    
    @AfterClass
    public static void removeDBUnitData() throws Exception {
        List<String> reversedDataFiles = new ArrayList<String>(DATA_FILES);
        Collections.reverse(reversedDataFiles);
        removeDBUnitData(reversedDataFiles);
    }
    
    @Test
    public void testAddPeerReviewToUnclaimedRecordPreservePeerReviewVisibility() {
        when(sourceManager.retrieveSourceEntity()).thenReturn(new SourceEntity(new ClientDetailsEntity(CLIENT_1_ID)));   
        PeerReview peer = getPeerReview(null);
        
        peer = peerReviewManager.createPeerReview(unclaimedOrcid, peer, true);
        peer = peerReviewManager.getPeerReview(unclaimedOrcid, peer.getPutCode());
        
        assertNotNull(peer);
        assertEquals(Visibility.PUBLIC, peer.getVisibility());        
    }
    
    @Test
    public void testAddPeerReviewToClaimedRecordPreserveUserDefaultVisibility() {
        when(sourceManager.retrieveSourceEntity()).thenReturn(new SourceEntity(new ClientDetailsEntity(CLIENT_1_ID)));                
        PeerReview peer = getPeerReview(null);
        
        peer = peerReviewManager.createPeerReview(claimedOrcid, peer, true);
        peer = peerReviewManager.getPeerReview(claimedOrcid, peer.getPutCode());
        
        assertNotNull(peer);
        assertEquals(Visibility.LIMITED, peer.getVisibility());       
    }
    
    @Test
    public void testAddMultipleModifiesIndexingStatus() {
        when(sourceManager.retrieveSourceEntity()).thenReturn(new SourceEntity(new ClientDetailsEntity(CLIENT_1_ID)));
        PeerReview p1 = getPeerReview("extId1");
        p1 = peerReviewManager.createPeerReview(claimedOrcid, p1, true);
        
        PeerReview p2 = getPeerReview("extId2");
        p2 = peerReviewManager.createPeerReview(claimedOrcid, p2, true);
        
        PeerReview p3 = getPeerReview("extId3");
        p3 = peerReviewManager.createPeerReview(claimedOrcid, p3, true);
        
        PeerReviewEntity entity1 = peerReviewDao.find(p1.getPutCode());
        PeerReviewEntity entity2 = peerReviewDao.find(p2.getPutCode());
        PeerReviewEntity entity3 = peerReviewDao.find(p3.getPutCode());
        
        assertNotNull(entity1.getDisplayIndex());
        assertNotNull(entity2.getDisplayIndex());
        assertNotNull(entity3.getDisplayIndex());
        assertEquals(Long.valueOf(0), entity3.getDisplayIndex());
        
        //Rollback all changes
        peerReviewDao.remove(entity1.getId());
        peerReviewDao.remove(entity2.getId());
        peerReviewDao.remove(entity3.getId());
    }
    
    @Test
    public void displayIndexIsSetTo_1_FromUI() {
        when(sourceManager.retrieveSourceEntity()).thenReturn(new SourceEntity(new ClientDetailsEntity(CLIENT_1_ID)));
        PeerReview p1 = getPeerReview("fromUI-1");
        p1 = peerReviewManager.createPeerReview(claimedOrcid, p1, false);
        PeerReviewEntity p = peerReviewDao.find(p1.getPutCode());
        
        assertNotNull(p);
        assertEquals(Long.valueOf(1), p.getDisplayIndex());
    }
    
    @Test
    public void displayIndexIsSetTo_0_FromAPI() {
        when(sourceManager.retrieveSourceEntity()).thenReturn(new SourceEntity(new ClientDetailsEntity(CLIENT_1_ID)));
        PeerReview p1 = getPeerReview("fromAPI-1");
        p1 = peerReviewManager.createPeerReview(claimedOrcid, p1, true);
        PeerReviewEntity p = peerReviewDao.find(p1.getPutCode());
        
        assertNotNull(91);
        assertEquals(Long.valueOf(0), p.getDisplayIndex());
    }
    
    @Test
    public void testGroupPeerReviews() {
        /**
         * They should be grouped as
         * 
         * Group 1: ext-id-1 + ext-id-4
         * Group 2: ext-id-2 + ext-id-5
         * Group 3: ext-id-3 
         * Group 4: ext-id-6
         * */
        PeerReviewSummary s1 = getPeerReviewSummary("Group1", "ext-id-1", Visibility.PUBLIC);
        PeerReviewSummary s2 = getPeerReviewSummary("Group2", "ext-id-2", Visibility.LIMITED);
        PeerReviewSummary s3 = getPeerReviewSummary("Group3", "ext-id-3", Visibility.PRIVATE);
        PeerReviewSummary s4 = getPeerReviewSummary("Group1", "ext-id-4", Visibility.PRIVATE);
        PeerReviewSummary s5 = getPeerReviewSummary("Group2", "ext-id-5", Visibility.PUBLIC);
        PeerReviewSummary s6 = getPeerReviewSummary("Group4", "ext-id-6", Visibility.PRIVATE);
        
        List<PeerReviewSummary> peerReviewList1 = Arrays.asList(s1, s2, s3, s4, s5, s6); 
        
        PeerReviews peerReviews1 = peerReviewManager.groupPeerReviews(peerReviewList1, false);
        assertNotNull(peerReviews1);
        assertEquals(4, peerReviews1.getPeerReviewGroup().size());
        //Group 1 have all with ext-id-1
        assertEquals(2, peerReviews1.getPeerReviewGroup().get(0).getPeerReviewSummary().size());
        assertEquals(2, peerReviews1.getPeerReviewGroup().get(0).getIdentifiers().getExternalIdentifier().size());
        assertEquals("ext-id-1", peerReviews1.getPeerReviewGroup().get(0).getIdentifiers().getExternalIdentifier().get(0).getValue());
        
        //Group 2 have all with ext-id-2
        assertEquals(2, peerReviews1.getPeerReviewGroup().get(1).getPeerReviewSummary().size());
        assertEquals(1, peerReviews1.getPeerReviewGroup().get(1).getIdentifiers().getExternalIdentifier().size());
        assertEquals("ext-id-2", peerReviews1.getPeerReviewGroup().get(1).getIdentifiers().getExternalIdentifier().get(0).getValue());
        
        //Group 3 have ext-id-3
        assertEquals(1, peerReviews1.getPeerReviewGroup().get(2).getPeerReviewSummary().size());
        assertEquals(1, peerReviews1.getPeerReviewGroup().get(2).getIdentifiers().getExternalIdentifier().size());
        assertEquals("ext-id-3", peerReviews1.getPeerReviewGroup().get(2).getIdentifiers().getExternalIdentifier().get(0).getValue());
        
        //Group 4 have ext-id-4
        assertEquals(1, peerReviews1.getPeerReviewGroup().get(3).getPeerReviewSummary().size());
        assertEquals(1, peerReviews1.getPeerReviewGroup().get(3).getIdentifiers().getExternalIdentifier().size());
        assertEquals("ext-id-4", peerReviews1.getPeerReviewGroup().get(3).getIdentifiers().getExternalIdentifier().get(0).getValue());
        
        PeerReviewSummary s7 = getPeerReviewSummary("PeerReview 7", "ext-id-4", Visibility.PRIVATE);
        //Add ext-id-3 to work 7, so, it join group 3 and group 4 in a single group
        ExternalID extId = new ExternalID();
        extId.setRelationship(Relationship.SELF);
        extId.setType("doi");
        extId.setUrl(new Url("http://orcid.org"));        
        extId.setValue("ext-id-3"); 
        s7.getExternalIdentifiers().getExternalIdentifier().add(extId);
        
        /**
         * Now, they should be grouped as
         * 
         * Group 1: PeerReview 1 + PeerReview 4
         * Group 2: PeerReview 2 + PeerReview 5
         * Group 3: PeerReview 3 + PeerReview 6 + PeerReview 7
         * */
        List<PeerReviewSummary> peerReviewList2 = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
        
        PeerReviews peerReviews2 = peerReviewManager.groupPeerReviews(peerReviewList2, false);
        assertNotNull(peerReviews2);
        assertEquals(3, peerReviews2.getPeerReviewGroup().size());
        //Group 1 have all with ext-id-1
        assertEquals(2, peerReviews2.getPeerReviewGroup().get(0).getPeerReviewSummary().size());
        assertEquals(1, peerReviews2.getPeerReviewGroup().get(0).getIdentifiers().getExternalIdentifier().size());
        assertEquals("ext-id-1", peerReviews2.getPeerReviewGroup().get(0).getIdentifiers().getExternalIdentifier().get(0).getValue());
        
        //Group 2 have all with ext-id-2
        assertEquals(2, peerReviews2.getPeerReviewGroup().get(1).getPeerReviewSummary().size());
        assertEquals(1, peerReviews2.getPeerReviewGroup().get(1).getIdentifiers().getExternalIdentifier().size());
        assertEquals("ext-id-2", peerReviews2.getPeerReviewGroup().get(1).getIdentifiers().getExternalIdentifier().get(0).getValue());
        
        //Group 3 have all with ext-id-3 and ext-id-4
        assertEquals(3, peerReviews2.getPeerReviewGroup().get(2).getPeerReviewSummary().size());
        assertEquals(2, peerReviews2.getPeerReviewGroup().get(2).getIdentifiers().getExternalIdentifier().size());
        assertEquals("ext-id-4", peerReviews2.getPeerReviewGroup().get(2).getIdentifiers().getExternalIdentifier().get(0).getValue());
        assertEquals("ext-id-3", peerReviews2.getPeerReviewGroup().get(2).getIdentifiers().getExternalIdentifier().get(1).getValue());
    }
    
    @Test
    public void testGroupPeerReviews_groupOnlyPublicPeerReviews1() {
        PeerReviewSummary s1 = getPeerReviewSummary("Public 1", "ext-id-1", Visibility.PUBLIC);
        PeerReviewSummary s2 = getPeerReviewSummary("Limited 1", "ext-id-2", Visibility.LIMITED);
        PeerReviewSummary s3 = getPeerReviewSummary("Private 1", "ext-id-3", Visibility.PRIVATE);
        PeerReviewSummary s4 = getPeerReviewSummary("Public 2", "ext-id-4", Visibility.PUBLIC);
        PeerReviewSummary s5 = getPeerReviewSummary("Limited 2", "ext-id-5", Visibility.LIMITED);
        PeerReviewSummary s6 = getPeerReviewSummary("Private 2", "ext-id-6", Visibility.PRIVATE);
        PeerReviewSummary s7 = getPeerReviewSummary("Public 3", "ext-id-7", Visibility.PUBLIC);
        PeerReviewSummary s8 = getPeerReviewSummary("Limited 3", "ext-id-8", Visibility.LIMITED);
        PeerReviewSummary s9 = getPeerReviewSummary("Private 3", "ext-id-9", Visibility.PRIVATE);
        
        List<PeerReviewSummary> workList = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9);
        
        /**
         * They should be grouped as
         * 
         * Group 1: Public 1
         * Group 2: Public 2
         * Group 3: Public 3
         * */
        PeerReviews peerReviews = peerReviewManager.groupPeerReviews(workList, true);
        assertNotNull(peerReviews);
        assertEquals(3, peerReviews.getPeerReviewGroup().size());
        assertEquals(1, peerReviews.getPeerReviewGroup().get(0).getIdentifiers().getExternalIdentifier().size());
        assertEquals(1, peerReviews.getPeerReviewGroup().get(0).getPeerReviewSummary().size());
        assertEquals("ext-id-1", peerReviews.getPeerReviewGroup().get(0).getIdentifiers().getExternalIdentifier().get(0).getValue());
        assertEquals("Public 1", peerReviews.getPeerReviewGroup().get(0).getPeerReviewSummary().get(0).getGroupId());
        assertEquals(1, peerReviews.getPeerReviewGroup().get(1).getIdentifiers().getExternalIdentifier().size());
        assertEquals(1, peerReviews.getPeerReviewGroup().get(1).getPeerReviewSummary().size());
        assertEquals("ext-id-4", peerReviews.getPeerReviewGroup().get(1).getIdentifiers().getExternalIdentifier().get(0).getValue());
        assertEquals("Public 2", peerReviews.getPeerReviewGroup().get(1).getPeerReviewSummary().get(0).getGroupId());
        assertEquals(1, peerReviews.getPeerReviewGroup().get(2).getIdentifiers().getExternalIdentifier().size());
        assertEquals(1, peerReviews.getPeerReviewGroup().get(2).getPeerReviewSummary().size());
        assertEquals("ext-id-7", peerReviews.getPeerReviewGroup().get(2).getIdentifiers().getExternalIdentifier().get(0).getValue());
        assertEquals("Public 3", peerReviews.getPeerReviewGroup().get(2).getPeerReviewSummary().get(0).getGroupId());
    }
    
    @Test
    public void testGroupPeerReviews_groupOnlyPublicPeerReviews2() {
        PeerReviewSummary s1 = getPeerReviewSummary("Public 1", "ext-id-1", Visibility.PUBLIC);
        PeerReviewSummary s2 = getPeerReviewSummary("Limited 1", "ext-id-1", Visibility.LIMITED);
        PeerReviewSummary s3 = getPeerReviewSummary("Private 1", "ext-id-1", Visibility.PRIVATE);
        PeerReviewSummary s4 = getPeerReviewSummary("Public 2", "ext-id-1", Visibility.PUBLIC);
        PeerReviewSummary s5 = getPeerReviewSummary("Limited 2", "ext-id-1", Visibility.LIMITED);
        PeerReviewSummary s6 = getPeerReviewSummary("Private 2", "ext-id-1", Visibility.PRIVATE);
        PeerReviewSummary s7 = getPeerReviewSummary("Public 3", "ext-id-2", Visibility.PUBLIC);
        PeerReviewSummary s8 = getPeerReviewSummary("Limited 3", "ext-id-2", Visibility.LIMITED);
        PeerReviewSummary s9 = getPeerReviewSummary("Private 3", "ext-id-2", Visibility.PRIVATE);        
        
        List<PeerReviewSummary> peerReviewList = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9);
        
        /**
         * They should be grouped as
         * 
         * Group 1: Public 1 + Public 2
         * Group 2: Public 3
         * */
        PeerReviews peerReviews = peerReviewManager.groupPeerReviews(peerReviewList, true);
        assertNotNull(peerReviews);
        assertEquals(2, peerReviews.getPeerReviewGroup().size());
        assertEquals(1, peerReviews.getPeerReviewGroup().get(0).getIdentifiers().getExternalIdentifier().size());
        assertEquals("ext-id-1", peerReviews.getPeerReviewGroup().get(0).getIdentifiers().getExternalIdentifier().get(0).getValue());
        assertEquals(2, peerReviews.getPeerReviewGroup().get(0).getPeerReviewSummary().size());
        assertEquals("Public 1", peerReviews.getPeerReviewGroup().get(0).getPeerReviewSummary().get(0).getGroupId());
        assertEquals("Public 2", peerReviews.getPeerReviewGroup().get(0).getPeerReviewSummary().get(1).getGroupId());        
        assertEquals(1, peerReviews.getPeerReviewGroup().get(1).getIdentifiers().getExternalIdentifier().size());
        assertEquals("ext-id-2", peerReviews.getPeerReviewGroup().get(1).getIdentifiers().getExternalIdentifier().get(0).getValue());
        assertEquals(1, peerReviews.getPeerReviewGroup().get(1).getPeerReviewSummary().size());
        assertEquals("Public 3", peerReviews.getPeerReviewGroup().get(1).getPeerReviewSummary().get(0).getGroupId());
    }
    
    private PeerReviewSummary getPeerReviewSummary(String titleValue, String extIdValue, Visibility visibility) {
        PeerReviewSummary summary = new PeerReviewSummary();
        summary.setGroupId(titleValue);
        summary.setVisibility(visibility);        
        ExternalIDs extIds = new ExternalIDs();
        ExternalID extId = new ExternalID();
        extId.setRelationship(Relationship.SELF);
        extId.setType("doi");
        extId.setUrl(new Url("http://orcid.org"));        
        extId.setValue(extIdValue);               
        extIds.getExternalIdentifier().add(extId);
        summary.setExternalIdentifiers(extIds);
        return summary;
    }
    
    private PeerReview getPeerReview(String extIdValue) {
        PeerReview peerReview = new PeerReview();
        peerReview.setRole(Role.CHAIR);
        ExternalIDs extIds = new ExternalIDs();
        ExternalID extId = new ExternalID();
        extId.setRelationship(Relationship.SELF);
        extId.setType("doi");
        extId.setUrl(new Url("http://orcid.org"));
        if(extIdValue == null) {
            extId.setValue("ext-id-value");
        } else {
            extId.setValue("ext-id-value-" + extIdValue);
        }
        extIds.getExternalIdentifier().add(extId);
        peerReview.setExternalIdentifiers(extIds);       
        if(extIdValue == null) {
            peerReview.setSubjectContainerName(new Title("Peer review title"));
        } else {
            peerReview.setSubjectContainerName(new Title("Peer review title " + extIdValue));
        }
        peerReview.setSubjectExternalIdentifier(extId);
        
        Organization org = new Organization();
        org.setName("org-name");
        OrganizationAddress address = new OrganizationAddress();
        address.setCity("city");
        address.setCountry(Iso3166Country.US);
        org.setAddress(address);
        
        peerReview.setOrganization(org);
        peerReview.setType(PeerReviewType.EVALUATION);
        peerReview.setVisibility(Visibility.PUBLIC);
        
        return peerReview;
    }
}
