package cenarios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import model.AssociadoJson;

/**
 * Class developed to test the scenario described at User Story 
 * @author thiarlles.a.gomes
 *
 */
public class CenariosOperacoesAssociado {
 
	static final String URL_SERVICE = "http://localhost:9080/associados";
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
			restTemplate = new RestTemplate();
			httpEntity = new HttpEntity <String> (jsonObject.toString(), httpHeaders);
			restTemplate.postForObject(URL_SERVICE, httpEntity, HttpStatus.class);  		   
	   
	}
	
	
   @Then("Se o cadastro ocorreu com sucesso a resposta deverá possui código $codigo")
	public void respostaDefinir(Integer codigo) {
	    response = restTemplate.postForObject(URL_SERVICE, httpEntity, HttpStatus.class);  
	    Assert.assertTrue(response.value() == codigo);
	}
   
  @Then("O associado deverá ter o CPF $cpf cadastrado")
   public void testarCPFCadastrado(String cpf) {
	   final String URL = "http://localhost:9080/associados/{id}";
	   Map<String, Long>parameters = new HashMap<>();
	   parameters.put("id", new Long(1));
	   restTemplate = new RestTemplate();
	   model.AssociadoJson associado = restTemplate.getForObject(URL, model.AssociadoJson.class, parameters);
	   Assert.assertTrue(associado.getCpfAssociado().equals(cpf));	   
   }
   
   @Then("Na base de dados deverá haver $quantidade_registros elemento")
   public void verificarTamanhoLista(Integer quantidade_registros) {
	   restTemplate = new RestTemplate();
	   ResponseEntity<List<AssociadoJson>>listaAssociados = restTemplate.exchange(URL_SERVICE,
			   HttpMethod.GET, null, new ParameterizedTypeReference<List<AssociadoJson>>() {
			});
	   Assert.assertTrue(listaAssociados.getBody().size() == quantidade_registros);
	   
   }
	

}
