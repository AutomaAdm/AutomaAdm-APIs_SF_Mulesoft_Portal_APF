<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>QA - MS-Cumulo</name>
   <tag></tag>
   <elementGuidId>b5af4884-ae17-4f21-80ae-30eb4b8b59b2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
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
      <webElementGuid>5264065d-70ca-4ddc-b140-ea6487925656</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN_INSTITU}</value>
      <webElementGuid>23ae4b36-49ae-4c53-bfa6-1fa2e236458c</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.HOST_CUMULO_MULE}/sb-cumulo/api/permitido</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'CAEJ9002118V4'</defaultValue>
      <description></description>
      <id>d7a3b46e-c836-4b10-b42c-47b6b8d0ff43</id>
      <masked>false</masked>
      <name>rfc</name>
   </variables>
   <variables>
      <defaultValue>'CASTANEDA'</defaultValue>
      <description></description>
      <id>3797defb-57ad-4ed7-b3b4-c6d2c14c94b9</id>
      <masked>false</masked>
      <name>paterno</name>
   </variables>
   <variables>
      <defaultValue>'ESPINOZA'</defaultValue>
      <description></description>
      <id>7bfe7baa-00dd-4967-9ebf-cb1a11e46707</id>
      <masked>false</masked>
      <name>materno</name>
   </variables>
   <variables>
      <defaultValue>'ANETH ANDREA'</defaultValue>
      <description></description>
      <id>60288d81-7bb0-4f01-9256-1aea64148f85</id>
      <masked>false</masked>
      <name>nombre</name>
   </variables>
   <variables>
      <defaultValue>15000000</defaultValue>
      <description></description>
      <id>3bb7b540-dc7c-4ae4-bd39-4d80a2e2e745</id>
      <masked>false</masked>
      <name>sumaAsegurada</name>
   </variables>
   <variables>
      <defaultValue>56</defaultValue>
      <description></description>
      <id>32eb5972-8a0d-4cfe-a4bb-a23ac7c40524</id>
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
