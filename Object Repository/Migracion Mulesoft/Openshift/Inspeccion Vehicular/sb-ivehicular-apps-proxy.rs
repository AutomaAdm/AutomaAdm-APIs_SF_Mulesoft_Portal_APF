<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>sb-ivehicular-apps-proxy</name>
   <tag></tag>
   <elementGuidId>15431160-ddec-43e2-9d3e-e4d7f262acc3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\n    \&quot;codPromotor\&quot;: \&quot;1084-P\&quot;,\n    \&quot;codAgente\&quot;: \&quot;19995\&quot;,\n    \&quot;codOficina\&quot;: \&quot;7J8\&quot;,\n    \&quot;lineaCanalSub\&quot;: 1,\n    \&quot;codTipoVehiculo\&quot;: \&quot;1\&quot;,\n    \&quot;codPlan\&quot;: \&quot;${codPlan}\&quot;,\n    \&quot;codEstado\&quot;: \&quot;${codEstado}\&quot;,\n    \&quot;codMunicipio\&quot;: \&quot;${codMunicipio}\&quot;,\n    \&quot;codMarcaVehiculo\&quot;: \&quot;${codMarcaVehiculo}\&quot;,\n    \&quot;codTipoReducido\&quot;: ${codTipoReducido},\n    \&quot;anioVehiculo\&quot;: ${anioVehiculo},\n    \&quot;sumaAsegurada\&quot;: ${sumaAsegurada},\n    \&quot;codUsoVehiculo\&quot;: \&quot;1\&quot;,\n    \&quot;sessionUser\&quot;: \&quot;${sessionUser}\&quot;\n\n}&quot;,
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
      <webElementGuid>aa89898d-a31b-4199-a933-935ab19e3573</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.7.2</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.HOST_REGLAINSPECTION}/ivr-ms-integration-api-service/reglaInspeccion</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'A03'</defaultValue>
      <description></description>
      <id>a18d2750-1d68-42b8-98d9-7e198b058c70</id>
      <masked>false</masked>
      <name>codPlan</name>
   </variables>
   <variables>
      <defaultValue>'07'</defaultValue>
      <description></description>
      <id>c35d3863-6a46-4124-b758-fbc7da7e3f72</id>
      <masked>false</masked>
      <name>codEstado</name>
   </variables>
   <variables>
      <defaultValue>'019'</defaultValue>
      <description></description>
      <id>2d1c86f5-5617-49a3-ba7e-6845be1cdcd3</id>
      <masked>false</masked>
      <name>codMunicipio</name>
   </variables>
   <variables>
      <defaultValue>'AC'</defaultValue>
      <description></description>
      <id>95685f0b-fe3b-4e22-9743-5270a8ed1a24</id>
      <masked>false</masked>
      <name>codMarcaVehiculo</name>
   </variables>
   <variables>
      <defaultValue>7</defaultValue>
      <description></description>
      <id>b87ac2df-30b1-46f4-b049-17b6fb4206dd</id>
      <masked>false</masked>
      <name>codTipoReducido</name>
   </variables>
   <variables>
      <defaultValue>2015</defaultValue>
      <description></description>
      <id>22e04c5b-467b-4785-a15e-c1ff798f72cc</id>
      <masked>false</masked>
      <name>anioVehiculo</name>
   </variables>
   <variables>
      <defaultValue>420947</defaultValue>
      <description></description>
      <id>b5a6debf-ab74-4066-9a53-a8f0460a4f85</id>
      <masked>false</masked>
      <name>sumaAsegurada</name>
   </variables>
   <variables>
      <defaultValue>'AABF830222HDFLSR06'</defaultValue>
      <description></description>
      <id>58a2fe27-5a39-4064-a692-f94d1026a3db</id>
      <masked>false</masked>
      <name>sessionUser</name>
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
