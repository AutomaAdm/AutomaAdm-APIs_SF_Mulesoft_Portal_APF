<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Emision - (new)</name>
   <tag></tag>
   <elementGuidId>adebbf24-b147-4558-8870-034d2e8e1efd</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
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
      <webElementGuid>7b03166e-0102-416c-b046-c3bb76b1c899</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.5</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.HOST}/services/apexrest/vlocity_ins/v1/integrationprocedure/ClbIns_Emission/?curpId=${vCurpId}&amp;quoteId=${vQuoteId}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'AABF830222HDFLSR06'</defaultValue>
      <description></description>
      <id>68ca61eb-1183-4ff9-98ff-58e0ba7760fd</id>
      <masked>false</masked>
      <name>vCurpId</name>
   </variables>
   <variables>
      <defaultValue>'w2C8MVDmyZqjmaAxT8YnrO28RDIWnF5LiZ0iDcAs5Cc.bM_WXGSBAzA86VqS5sAZHpFshHIzQWSMRxr69IK3HY9GG27TB794X91-9I8-yAhy'</defaultValue>
      <description></description>
      <id>81d90b73-cc08-4bb7-899d-dbdbb3e2d3e9</id>
      <masked>false</masked>
      <name>vQuoteId</name>
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
