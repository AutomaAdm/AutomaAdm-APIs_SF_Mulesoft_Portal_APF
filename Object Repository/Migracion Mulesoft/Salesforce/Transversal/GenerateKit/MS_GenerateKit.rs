<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MS_GenerateKit</name>
   <tag></tag>
   <elementGuidId>18eec0c8-4a23-4355-8b98-632d740cc79c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN}</value>
      <webElementGuid>6b6e26d2-1ad7-4370-a7dc-47a3447e002a</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.HOSTNAME_MULESOFT}/services/apexrest/vlocity_ins/v1/integrationprocedure/ClbIns_GenerateKit/?curpId=${curpId)&amp;quoteId=${quoteId}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'wI9arbFGGZjJ-jif4hiXtMx-8d-Fmp_nkb3fhl6iKzg.y4sVoC2kZSGatzXZJVjOF9Xktfq6_AHx375X-lWFsrSoDxG4ZB4KbLdzS0vk7SsJ'</defaultValue>
      <description></description>
      <id>6f6e5629-0d15-4bab-8018-cf95a429cc35</id>
      <masked>false</masked>
      <name>quoteId</name>
   </variables>
   <variables>
      <defaultValue>'EAJE711007HDFSMR04'</defaultValue>
      <description></description>
      <id>bd538304-9813-4890-9e1c-14bbd4b78d85</id>
      <masked>false</masked>
      <name>curpId</name>
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
