<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Cumulo</name>
   <tag></tag>
   <elementGuidId>95ef8a38-99e3-4b3d-b3a5-41064c5ebf8a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;rfc\&quot;: \&quot;${rfc}\&quot;,\n    \&quot;paterno\&quot;: \&quot;${paterno}\&quot;,\n    \&quot;materno\&quot;: \&quot;${materno}\&quot;,\n    \&quot;nombre\&quot;: \&quot;${nombre}\&quot;,\n    \&quot;producto\&quot;: \&quot;VIDA INDIVIDUAL APF\&quot;,\n    \&quot;sumaAsegurada\&quot;: ${sumaAsegurada},\n    \&quot;edad\&quot;: ${edad}\n}&quot;,
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
      <webElementGuid>2e454bc5-dd38-4a20-882b-84c56188eb4a</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN_INSTITU}</value>
      <webElementGuid>48d78b9b-1b97-428b-8d0e-3d6479a76aaa</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://syp-arq-capps-apicumulo.apps.sbc-qas.segurosbanorte.com/sb-cumulo/api/permitido</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'CAEJ9002118V4'</defaultValue>
      <description></description>
      <id>5b3b6211-0671-4142-b675-a848bfcbd978</id>
      <masked>false</masked>
      <name>rfc</name>
   </variables>
   <variables>
      <defaultValue>'CASTANEDA'</defaultValue>
      <description></description>
      <id>17b35e16-6c83-4a6d-9c3f-95aa7688a422</id>
      <masked>false</masked>
      <name>paterno</name>
   </variables>
   <variables>
      <defaultValue>'ESPINOZA'</defaultValue>
      <description></description>
      <id>5788264b-640b-484b-9362-a67705f18607</id>
      <masked>false</masked>
      <name>materno</name>
   </variables>
   <variables>
      <defaultValue>'ANETH ANDREA'</defaultValue>
      <description></description>
      <id>6327e343-d262-4d08-9ae1-8ce12abdb3f4</id>
      <masked>false</masked>
      <name>nombre</name>
   </variables>
   <variables>
      <defaultValue>15000000</defaultValue>
      <description></description>
      <id>11348fd3-8042-4567-b446-a75c7383d1e9</id>
      <masked>false</masked>
      <name>sumaAsegurada</name>
   </variables>
   <variables>
      <defaultValue>56</defaultValue>
      <description></description>
      <id>1d675c4f-f0fe-4690-bf85-8f96b818b5bc</id>
      <masked>false</masked>
      <name>edad</name>
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
