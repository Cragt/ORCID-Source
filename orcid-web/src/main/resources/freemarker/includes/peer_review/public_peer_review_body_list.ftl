<#--

    =============================================================================

    ORCID (R) Open Source
    http://orcid.org

    Copyright (c) 2012-2014 ORCID, Inc.
    Licensed under an MIT-Style License (MIT)
    http://orcid.org/open-source-license

    This copyright and license information (including a link to the full license)
    shall be included in its entirety in all copies or substantial portion of
    the software.

    =============================================================================

-->
<#escape x as x?html>
	<#-- noscript is for search engines -->
	<noscript ng-non-bindable>
		<#if (peerReviews)??>			
			<ul class="workspace-publications workspace-body-list">             
                <#list peerReviews as peerReview>                                       
                    <div>
                        <h3 class="work-title">
                            <#if peerReview.subject.title?? && peerReview.subject.title.title.content??>
                                <#if peerReview.subject.journalTitle?? && peerReview.subject.journalTitle.content??>
                                    <strong>${peerReview.subject.title.title.content}</strong>: <span class="work-subtitle">${peerReview.subject.journalTitle.content}</span>
                                <#else>
                                    <strong>${peerReview.subject.title.title.value}</strong>
                                </#if>
                                <#if peerReview.completionDate??>
                                    <#assign date = '' >
                                    <#if peerReview.completionDate.year??>
                                        <#assign date = date + peerReview.completionDate.year.value>
                                    </#if>
                                    <#if peerReview.completionDate.month??>
                                         <#if peerReview.completionDate.day??>
                                            <#assign date = date + '-' + peerReview.completionDate.day.value >
                                        </#if>
                                        <#assign date = date + '-' + peerReview.completionDate.month.value >
                                    </#if>                                  
                                    ${date}
                                </#if>                                
                            </#if>
                        </h3>                       
                    </div>
                </#list>
            </ul>			
		</#if>
		 
	</noscript>
	<div>		
		<#include "peer_review_body_inc.ftl"/>
	</div>
</#escape>