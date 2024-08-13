<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MS_ClbInsOnboardingWsbd</name>
   <tag></tag>
   <elementGuidId>04ac007b-0889-4732-b503-d5ae48d32d4c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
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
      <name>Content-Type</name>
      <type>Main</type>
      <value>text/plain</value>
      <webElementGuid>c24eab42-7c50-4c5c-ba3d-d0683b8cd357</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN}</value>
      <webElementGuid>c732adfc-eb37-4607-baa0-39fde2e4fd7a</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.HOSTNAME_MULESOFT}/services/apexrest/vlocity_ins/v1/integrationprocedure/ClbIns_OnboardingWsbd/?quoteId=${quoteId}&amp;curp=${curp}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'JtJz1MuJz6MDshnEHTEvqelnrpY-SGFSDRXd7AZua9E.1iekbjWr-WTLvGAVWQt6O3CfqbbjMqikDRdzx7mP2pZkl17jaqAMzWTr-HvRfYKy'</defaultValue>
      <description></description>
      <id>42adc6cf-a36a-4a79-97e5-cd0258121806</id>
      <masked>false</masked>
      <name>quoteId</name>
   </variables>
   <variables>
      <defaultValue>'EAJE711007HDFSMR04'</defaultValue>
      <description></description>
      <id>27dd5a70-0c0a-4169-a4a8-272d4dd9b2b1</id>
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
