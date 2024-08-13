<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MS_GetReceiptsData</name>
   <tag></tag>
   <elementGuidId>766ddcde-7477-4482-b309-34aea5f1abe9</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;price\&quot;: \&quot;${price}\&quot;,\n    \&quot;total\&quot;: \&quot;${total}\&quot;,\n    \&quot;taxAmount\&quot;: \&quot;${taxAmount}\&quot;,\n    \&quot;priceWithExpense\&quot;: \&quot;${priceWithExpense}\&quot;,\n    \&quot;expense\&quot;: ${expense},\n    \&quot;numInstallments\&quot;: \&quot;${numInstallments}\&quot;,\n    \&quot;productCode\&quot;: \&quot;${productCode}\&quot;\n}&quot;,
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
      <webElementGuid>bd243acd-c1f3-4416-8d5f-f343948232d3</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN}</value>
      <webElementGuid>0ddc59dd-a14a-4b86-92db-cc5c58a1a362</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.8</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.HOSTNAME_MULESOFT}/services/apexrest/vlocity_ins/v1/integrationprocedure/ClbIns_GetReceiptsData/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'1500'</defaultValue>
      <description></description>
      <id>1ec545e0-142f-45b8-b92e-05dae2ea89f2</id>
      <masked>false</masked>
      <name>price</name>
   </variables>
   <variables>
      <defaultValue>'2320'</defaultValue>
      <description></description>
      <id>3fda0764-7541-4073-88a3-31885f8191c8</id>
      <masked>false</masked>
      <name>total</name>
   </variables>
   <variables>
      <defaultValue>'320'</defaultValue>
      <description></description>
      <id>de2ec97e-46d2-4671-9b80-62386721e672</id>
      <masked>false</masked>
      <name>taxAmount</name>
   </variables>
   <variables>
      <defaultValue>'200'</defaultValue>
      <description></description>
      <id>eecef58b-c2d8-4d78-a503-c50c5276c5df</id>
      <masked>false</masked>
      <name>priceWithExpense</name>
   </variables>
   <variables>
      <defaultValue>500</defaultValue>
      <description></description>
      <id>37a18663-e712-4d73-b99e-41075e0d09ae</id>
      <masked>false</masked>
      <name>expense</name>
   </variables>
   <variables>
      <defaultValue>'12'</defaultValue>
      <description></description>
      <id>e00d6e8c-ab7d-4999-9bc4-18d368b157fa</id>
      <masked>false</masked>
      <name>numInstallments</name>
   </variables>
   <variables>
      <defaultValue>'SEGURO_CASA_HABITACION_APF_PROPIO_ROOT'</defaultValue>
      <description></description>
      <id>93477cd3-2e7a-45d9-9d7a-39b1de7e3441</id>
      <masked>false</masked>
      <name>productCode</name>
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
