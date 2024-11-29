<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>sb-ivr-capps-inspection</name>
   <tag></tag>
   <elementGuidId>06e5c1db-314f-48f5-9ded-811d0213eab1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;codProd\&quot;: \&quot;A003\&quot;,\n  \&quot;sessionUser\&quot;: \&quot;2276916\&quot;,\n  \&quot;origin\&quot;: \&quot;APF\&quot;,\n  \&quot;numOfi\&quot;: \&quot;7J8\&quot;,\n  \&quot;numCert\&quot;: 1,\n  \&quot;ip\&quot;: \&quot;127.0.0.1\&quot;,\n  \&quot;idePol\&quot;: 1,\n  \&quot;dateQuote\&quot;: \&quot;2024-11-14 12:00:00\&quot;,\n  \&quot;contractorName\&quot;: \&quot;YASMIN EDUARDA\&quot;,\n  \&quot;contractorLastname\&quot;: \&quot;RODRIGUEZ CABRERA\&quot;,\n  \&quot;phone\&quot;: \&quot;5616978120\&quot;,\n  \&quot;email\&quot;: \&quot;jrmendozav@desarrollo-ultrasist.com.mx\&quot;,\n  \&quot;numQuote\&quot;: \&quot;10000145\&quot;,\n  \&quot;numPolicy\&quot;: \&quot;2000145\&quot;,\n  \&quot;idInspection\&quot;: \&quot;1716\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>aef7d9cf-ef16-47c4-bfb1-1f8e45aa5ac6</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.7.2</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://mule-entornos.segurosbanorte.com/sb-ivr-capps-inspection-qa/api/inspections</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
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
