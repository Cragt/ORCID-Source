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
<@public classes=['home']>
    <div class="row member-list" ng-controller="MemberPageController" ng-init="membersListSrvc.getCurrentMemberDetailsBySlug('${memberSlug}')">
        <div class="col-md-9 col-md-offset-3 col-sm-12 col-xs-12">
        	<p><a href="<@orcid.rootPath '/members'/>"><i class="glyphicon x075 glyphicon-chevron-left"></i> All members</a></p>
        	<div class="row">
        		<div class="col-md-12 col-sm-12 col-xs-12">
		            <h1 ng-cloak>{{membersListSrvc.currentMemberDetails.member.name}}</h1>
		            <p ng-cloak>{{membersListSrvc.currentMemberDetails.member.researchCommunity}} | {{membersListSrvc.currentMemberDetails.member.country}}</p>
		        </div>
		        <div class="col-md-10 col-sm-10 col-xs-12">		       
		       		<p>
                    	<img class="member-logo" src="{{membersListSrvc.currentMemberDetails.member.logoUrl}}"  ng-cloak ng-if="membersListSrvc.currentMemberDetails.member.logoUrl">
                    	<span class="member-decsription" ng-bind-html="renderHtml(membersListSrvc.currentMemberDetails.member.description)" ng-if="membersListSrvc.currentMemberDetails.member.description" ng-cloak></span>
	                </p>	
		        </div>
		        <hr />
		        <div class="col-md-12 col-sm-12 col-xs-12" ng-if="membersListSrvc.currentMemberDetails.parentOrgName">		        	
                    <h3>Consortium/Parent Organization: </h3>
                    <p> 
	                    <span ng-show="membersListSrvc.currentMemberDetails.parentOrgName" ng-cloak><a ng-href="{{membersListSrvc.getMemberPageUrl(membersListSrvc.currentMemberDetails.parentOrgSlug)}}">{{membersListSrvc.currentMemberDetails.parentOrgName}}</a></span>
	                    <span ng-hide="membersListSrvc.currentMemberDetails.parentOrgName" ng-cloak>None</span>
	                </p>
	            <hr />
	            </div>
	            
	            <div class="col-md-12 col-sm-12 col-xs-12">   
	                <h3>Contacts</h3>
	                <div ng-if="membersListSrvc.currentMemberDetails.contacts" ng-repeat="contact in membersListSrvc.currentMemberDetails.contacts | orderBy : 'role'" ng-cloak>
	                	<p><b>{{contact.role}}</b></p>
	 					<ul>
		                    <li>{{contact.name}}</li>
		                    <li><a href="mailto:{{contact.email}}">{{contact.email}}</a></li>
	                    </ul>
	                </div>
	                
	                <div ng-hide="membersListSrvc.currentMemberDetails.contacts.length" ng-cloak> 
	                    <p>This member has not provided contact details.</p>
	                </div>	                
	            </div> 
	            <hr />
	            <div class="col-md-12 col-sm-12 col-xs-12">   
	                <h3>Integrations</h3>
	                <div ng-if="membersListSrvc.currentMemberDetails.integrations" ng-repeat="integration in membersListSrvc.currentMemberDetails.integrations" ng-cloak>
	                    <p><b>{{integration.name}}</b> <em>{{integration.stage}}</em></p>
	                    <p>
	                        <span ng-bind-html="renderHtml(integration.description)" ng-if="integration.description" ng-cloak>
	                            
	                        </span>
	                   </p>
	                   <p>
	                        <span ng-if="integration.resourceUrl" >
	                            <a href="{{integration.resourceUrl}}" target="_blank">Learn more about this integration</a>
	                        </span>
	                    </p>
	                </div>
	                <div ng-hide="membersListSrvc.currentMemberDetails.integrations.length"> 
	                    <p>This member has not completed any integrations.</p>
	                </div>
	                <hr />
				</div>
	            <div class="col-md-12 col-sm-12 col-xs-12" ng-if="membersListSrvc.currentMemberDetails.subMembers.length">
	                <h3>Consortium Members</h3>
	                <table ng-show="membersListSrvc.currentMemberDetails.subMembers">
	                	<tr>
	                		<th>Member Name</th>
	                		<th>Main Contact</th>
	                		<th>Email</th>
	                	</tr>
	                	<tr ng-repeat="subMember in membersListSrvc.currentMemberDetails.subMembers | orderBy : 'opportunity.accountName'">
							<td><a ng-href="{{membersListSrvc.getMemberPageUrl(subMember.slug)}}">{{subMember.opportunity.accountName}}</a></td>
							<td><span>{{subMember.mainContact.name}}</span></td>
							<td><a ng-href="mailto:{{subMember.mainContact.email}}">{{subMember.mainContact.email}}</a></td>
	                	</tr>
	                </table>
	                <div ng-hide="membersListSrvc.currentMemberDetails.subMembers.length"> 
						<p>This consortium does not have any members yet.</p>
						<hr />
	                </div>
	                
		        </div>
            </div>
        </div>
    </div>
</@public>