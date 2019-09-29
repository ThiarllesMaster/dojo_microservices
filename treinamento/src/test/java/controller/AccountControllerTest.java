package controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.TreinamentoApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.model.Account;
import domain.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = {TreinamentoApplication.class})
public class AccountControllerTest {

	private MockMvc mockMvc;
	
	 @Autowired
	 private WebApplicationContext webApplicationContext;
	  
	@MockBean
	private AccountRepository accountService;
	
	@Before
	public void setUp() {
		 this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testCreateAccount() throws Exception {
		
		Account account = new Account();
		account.setAccountId(12345L);
		account.setBank("Bank");
		
		when(accountService.createAccount(Mockito.any(Account.class))).thenReturn(12345L);
		
		mockMvc.perform(post("/api/account")
				.content(asJsonString(account))
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isCreated())
		.andExpect(jsonPath("$.accountId").value(""));
		
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  
}
