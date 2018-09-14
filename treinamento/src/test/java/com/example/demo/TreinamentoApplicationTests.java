package com.example.demo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreinamentoApplicationTests {

	static final String URL_SERVICE = "http://localhost:9080/associados";
	final Integer CODE_SUCESS_POST = 201;
	
	//@Test
	public void testMethodPost() throws JSONException {
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.set("Content-Type", "application/json");
	    JSONObject jsonObject = new JSONObject();
	    jsonObject.put("id", 1L);
	    jsonObject.put("nomeAssociado", "Thiarlles Duarte Gomes");
	    jsonObject.put("cpfAssociado", "");
	    
	    HttpEntity<String> httpEntity = new HttpEntity <String> (jsonObject.toString(), httpHeaders);

	    RestTemplate restTemplate = new RestTemplate();
	    HttpStatus response = restTemplate.postForObject(URL_SERVICE, httpEntity, HttpStatus.class);
	   
	    assertTrue(response.value() == CODE_SUCESS_POST);
        
	}
	
	@Test 
	public void testMethodGet() {
		 RestTemplate restTemplate = new RestTemplate();
		 ResponseEntity<List<Associado>> associadosRetornados =
			        restTemplate.exchange(URL_SERVICE, HttpMethod.GET, null, new ParameterizedTypeReference<List<Associado>>() {
					});
	      
		 List<Associado>associados = associadosRetornados.getBody();
		 associados.forEach(a->System.out.println(a.getCpfAssociado()));
		
		
		
	}
	

}


