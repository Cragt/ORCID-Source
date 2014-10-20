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
<div class="more-info content">
	<div class="row bottomBuffer">
		<div class="col-md-12"></div>
	</div>	
	<div class="row">
		<div class="col-md-6" ng-show="group.getActive().affiliationName.value" ng-cloak>
			
				<div class="bottomBuffer">
					  <strong ng-show="group.getActive().affiliationType.value == 'education'"><@orcid.msg 'manual_affiliation_form_contents.labelinstitution'/></strong>  
					<strong ng-show="group.getActive().affiliationType.value == 'employment'"><@orcid.msg 'manual_affiliation_form_contents.labelinstitutionemployer'/></strong>
					<strong ng-show="group.getActive().affiliationType.value != 'education' && group.getActive().affiliationType.value != 'employment'"><@orcid.msg 'manual_affiliation_form_contents.labelname'/></strong>
					<div ng-bind="group.getActive().affiliationName.value"></div>
				</div>
		</div>	
		
		<div class="col-md-6" ng-show="group.getActive().city.value" ng-cloak>
			<div class="bottomBuffer">
				<strong><@orcid.msg 'manual_affiliation_form_contents.labelcity'/></strong>
				<div ng-bind="group.getActive().city.value"></div>
			</div>
		</div>
		
		<div class="col-md-6" ng-show="group.getActive().region.value" ng-cloak>
			<div class="bottomBuffer">
				<strong><@orcid.msg 'manual_affiliation_form_contents.labelregion'/></strong>
				<div ng-bind="group.getActive().region.value"></div>
			</div>
		</div>
		
		<div class="col-md-6"  ng-show="group.getActive().country.value" ng-cloak>
			<div class="bottomBuffer">
				<strong><@orcid.msg 'manual_affiliation_form_contents.labelcountry'/></strong>
				<div ng-bind="group.getActive().country.value"></div>
			</div>
		</div>
		<div class="col-md-6" ng-show="group.getActive().departmentName.value" ng-cloak>
			<div class="bottomBuffer">
				<strong><@orcid.msg 'manual_affiliation_form_contents.labeldepartment'/></strong>
				<div ng-bind="group.getActive().departmentName.value"></div>
			</div>
		</div>
		
		<div class="col-md-6"  ng-show="group.getActive().roleTitle.value" ng-cloak>
			<div class="bottomBuffer">
				<strong ng-show="group.getActive().affiliationType.value == 'education'"><@orcid.msg 'manual_affiliation_form_contents.labeldegreetitle'/></strong>
				<strong ng-show="group.getActive().affiliationType.value != 'education'"><@orcid.msg 'manual_affiliation_form_contents.labelroletitle'/></strong>
				<div ng-bind="group.getActive().roleTitle.value"></div>
			</div>
		</div>
		
		
		<div class="col-md-6" ng-show="group.getActive().affiliationType.value" ng-cloak>
			<div class="bottomBuffer">
				<strong><@orcid.msg 'manual_affiliation_form_contents.labelaffiliationtype'/></strong>
				<div ng-bind="group.getActive().affiliationType.value"></div>
			</div>
		</div>
		
		<div class="col-md-6" ng-show="group.getActive().startDate.year" ng-cloak>
			<div class="bottomBuffer">				
				<strong><@orcid.msg 'manual_affiliation_form_contents.labelStartDate'/></strong>
				<div>		
					<span ng-show="group.getActive().startDate.year">{{group.getActive().startDate.year}}</span><span ng-show="group.getActive().startDate.month">-{{group.getActive().startDate.month}}</span><span ng-show="group.getActive().startDate.day && group.getActive().startDate.month">-{{group.getActive().startDate.day}}</span>
				</div>				
			</div>
		</div>
		
		<div class="col-md-6" ng-show="group.getActive().endDate.year" ng-cloak>
			<div class="bottomBuffer">				
				<strong><@orcid.msg 'manual_affiliation_form_contents.labelEndDate'/></strong>
				<div>									
					<span ng-show="group.getActive().endDate.year">{{group.getActive().endDate.year}}</span><span ng-show="group.getActive().endDate.month">-{{group.getActive().endDate.month}}</span><span ng-show="group.getActive().endDate.day && group.getActive().endDate.month">-{{group.getActive().endDate.day}}</span>
				</div>				
			</div>
		</div>
				
	</div>		
</div>
 