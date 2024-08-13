<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ClbInsOnboardingWsbd</name>
   <tag></tag>
   <elementGuidId>57e66df9-2801-4cd2-b6d7-8029e9f26931</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN}</value>
      <webElementGuid>6de6ea58-b78a-40ca-a0e5-4218f1750a37</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.HOST}/services/apexrest/vlocity_ins/v1/integrationprocedure/ClbIns_OnboardingWsbd/?quoteId=${quoteId}&amp;curp=${curp}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'qwuLrrlJeNv3pB_COFNCbEdttHoHQzddB-5JuUyNFj8.wjOLCvLNrh3HL3osW9HrS8sKruT0l8cn8gZbY84BLEhoZqKzYWmnSk5IJorirVTQ'</defaultValue>
      <description></description>
      <id>6efcc5e5-54f8-467b-89ad-5db724ea8b99</id>
      <masked>false</masked>
      <name>quoteId</name>
   </variables>
   <variables>
      <defaultValue>'HEGC780707MNTRMN04'</defaultValue>
      <description></description>
      <id>51f8d952-07ec-44d9-a165-5f5412447dc0</id>
      <masked>false</masked>
      <name>curp</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
