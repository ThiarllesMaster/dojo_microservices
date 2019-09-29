package domain.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import domain.model.Account;
import domain.repository.AccountRepository;

@RestController
public class AccountController {

	private AccountRepository accountService;

	@Autowired
	public AccountController(AccountRepository accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(value = { "/api/account" }, method = { RequestMethod.POST })
	public Account createAccount(@RequestBody Account account, HttpServletResponse httpResponse, WebRequest request) {
		Long accountId = accountService.createAccount(account);
		account.setAccountId(accountId);
		httpResponse.setStatus(HttpStatus.CREATED.value());
		httpResponse.setHeader("Location", String.format("%s/api/account/%s", request.getContextPath(), accountId));
		return account;
	}

}
