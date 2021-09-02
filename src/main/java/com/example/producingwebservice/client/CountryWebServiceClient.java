package com.example.producingwebservice.client;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

public class CountryWebServiceClient extends WebServiceGatewaySupport{

	public CountryWebServiceClient(String username, String password, int port) {
		super();
		ClientInterceptor[] interceptors = new ClientInterceptor[] {securityInterceptor(username,password)};
		this.setInterceptors(interceptors);
		this.setDefaultUri("http://localhost:"+port+"/ws");	
		Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
		marshaller.setContextPath("io.spring.guides.gs_producing_web_service");
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);
	}
	
	public GetCountryResponse getCountry(GetCountryRequest request) {
		return (GetCountryResponse)getWebServiceTemplate().marshalSendAndReceive(request);
	}
	
	public Wss4jSecurityInterceptor securityInterceptor(String username, String password){
        Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
        wss4jSecurityInterceptor.setSecurementActions("UsernameToken");
        wss4jSecurityInterceptor.setSecurementUsername(username);
        wss4jSecurityInterceptor.setSecurementPassword(password);
        return wss4jSecurityInterceptor;
    }
}
