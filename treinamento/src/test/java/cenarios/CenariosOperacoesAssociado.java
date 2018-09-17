package cenarios;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

/**
 * Class developed to test the scenario described at User Story 
 * @author thiarlles.a.gomes
 *
 */
public class CenariosOperacoesAssociado {
 
	static final String URL_SERVICE = "http://localhost:9080/associados";
	final Integer CODE_SUCESS_POST = 201;
	HttpEntity<String>httpEntity;
	JSONObject jsonObject;
	HttpHeaders httpHeaders;
	HttpStatus response;
	RestTemplate restTemplate;
	JSONObject jSonObject;

	@Given("Dado que eu decida cadastrar um associado com $id $nomeAssociado e $cpfAssociado")
	public void givenScenario(Long id, String nomeAssociado, String cpfAssociado) throws JSONException {
	    httpHeaders = new HttpHeaders();
	    httpHeaders.set("Content-Type", "application/json");
	    jsonObject = new JSONObject();
	    jsonObject.put("id", id);
	    jsonObject.put("nomeAssociado", nomeAssociado);
	    jsonObject.put("cpfAssociado", cpfAssociado);    	    
		
	}
	
	@When("Quando resolver cadastrar um associado")
	public void registrarAssociado() {
		try {
			restTemplate = new RestTemplate();
			System.out.println(restTemplate);
			System.out.println("Thiarlles");
			httpEntity = new HttpEntity <String> (jsonObject.toString(), httpHeaders);
			restTemplate.postForObject(URL_SERVICE, httpEntity, HttpStatus.class);  		   
			System.out.println(jsonObject);
		} catch (Exception e) {
			System.err.println(e);
		}
	   
	}
	
	
   @Then("Se o cadastro ocorreu com sucesso a resposta deverá possui código $codigo")
	public void respostaDefinir(Integer codigo) {
	    response = restTemplate.postForObject(URL_SERVICE, httpEntity, HttpStatus.class);  
		
	   System.out.println(response.value());
	}
	

}
