<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MS_GetHomePackages</name>
   <tag></tag>
   <elementGuidId>34ecf33f-2488-41b7-a339-966188b31374</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;propio\&quot;: {\n        \&quot;porcentajeContenidos\&quot;: \&quot;${rPorcentajeContenidos}\&quot;,\n        \&quot;aplicaTeev\&quot;: ${rAplicaTeev} ,\n        \&quot;aplicaContenidos\&quot;: ${rAplicaContenidos} ,\n        \&quot;codigoPostal\&quot;: \&quot;${rCodigoPostal}\&quot;,\n        \&quot;aplicaRcge\&quot;: ${rAplicaRcge} ,\n        \&quot;aplicaRhmt\&quot;: ${rAplicaRhmt},\n        \&quot;valorInmueble\&quot;: ${rValorInmueble},\n        \&quot;aplicaDmed\&quot;: ${rAplicaDmed},\n        \&quot;aplicaDmrb\&quot;: ${rAplicaDmrb} \n    },\n    \&quot;rentado\&quot;: {\n        \&quot;aplicaRhmt\&quot;: ${rAplicaRhmtR},\n        \&quot;aplicaTeev\&quot;:  ${rAplicaTeevR},\n        \&quot;aplicaDmed\&quot;: ${rAplicaDmedR},\n        \&quot;aplicaRcge\&quot;: ${rAplicaRcgeR} ,\n        \&quot;aplicaDmrb\&quot;: ${rAplicaDmrbR} ,\n        \&quot;codigoPostal\&quot;: \&quot;${rCodigoPostalR}\&quot;,\n        \&quot;valorContenidos\&quot;:  ${rValorContenidosR}\n    }\n}&quot;,
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
      <webElementGuid>fe49eabd-ca50-4e4d-98ac-cb53f5ba0909</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>${GlobalVariable.TOKEN}</value>
      <webElementGuid>d0a3ce1b-9123-49f3-a8d3-ac3b2d3f911b</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.6.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.HOSTNAME_MULESOFT}/services/apexrest/vlocity_ins/v1/integrationprocedure/ClbIns_GetHomePackages/?ignoreCache=false</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'20'</defaultValue>
      <description></description>
      <id>9c059d90-7540-40ce-a3bf-65455293ca71</id>
      <masked>false</masked>
      <name>rPorcentajeContenidos</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>7a2132ae-d894-4d76-90fd-8696f27cd6d3</id>
      <masked>false</masked>
      <name>rAplicaTeev</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>7abbef11-559d-4573-bceb-045ef301b5da</id>
      <masked>false</masked>
      <name>rAplicaContenidos</name>
   </variables>
   <variables>
      <defaultValue>'33387'</defaultValue>
      <description></description>
      <id>f1235001-00be-45dd-a6c1-48b90b6d187b</id>
      <masked>false</masked>
      <name>rCodigoPostal</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>b17b1af9-6fce-4f9d-bc7f-4f5c5120a95d</id>
      <masked>false</masked>
      <name>rAplicaRcge</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>d554c487-16ae-4f39-af6a-895b4119581b</id>
      <masked>false</masked>
      <name>rAplicaRhmt</name>
   </variables>
   <variables>
      <defaultValue>8000000</defaultValue>
      <description></description>
      <id>8bc6081a-c1f0-4d9f-be7b-9141c592055f</id>
      <masked>false</masked>
      <name>rValorInmueble</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>46e6ae1d-1f30-4e13-bb13-ca61b38ae363</id>
      <masked>false</masked>
      <name>rAplicaDmed</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>3ce37808-1196-4aa1-8e95-7048a2f6d0c5</id>
      <masked>false</masked>
      <name>rAplicaDmrb</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>e146968b-11cb-4f0e-9aad-960f2646464c</id>
      <masked>false</masked>
      <name>rAplicaRhmtR</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>61c3b7ef-08d6-4827-98c0-f06715888769</id>
      <masked>false</masked>
      <name>rAplicaTeevR</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>b3ae7491-dbfe-4962-9082-14e14a7d65a1</id>
      <masked>false</masked>
      <name>rAplicaDmedR</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>0f394ff3-ef89-44da-8a4d-df3985695b26</id>
      <masked>false</masked>
      <name>rAplicaRcgeR</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>7051e1e5-f997-421d-9b90-f54d7626ef06</id>
      <masked>false</masked>
      <name>rAplicaDmrbR</name>
   </variables>
   <variables>
      <defaultValue>'33387'</defaultValue>
      <description></description>
      <id>f7a32c1b-bec9-4ca7-83c2-bdb833b335cf</id>
      <masked>false</masked>
      <name>rCodigoPostalR</name>
   </variables>
   <variables>
      <defaultValue>1600000</defaultValue>
      <description></description>
      <id>c07feb38-c318-49e2-8175-95880052b9bc</id>
      <masked>false</masked>
      <name>rValorContenidosR</name>
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
