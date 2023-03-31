package betfairEx;

import betfairEx.dto.account.AccountDetailsResponseDTO;
import betfairEx.dto.login.LoginRequestDTO;
import betfairEx.service.extract.AccountService;
import betfairEx.service.extract.BettingService;

public class Main {
	public static void main(String[] args) throws Exception {
		
		AccountService accountService = new AccountService();
		LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
		BettingService bettingService = new BettingService();
		
		//LOGIN
		loginRequestDTO.setUsername("rodrig20002012@gmail.com");
		loginRequestDTO.setPassword("Futebol@27");
		
		//GET ACCOUNT INFO
		accountService.login(loginRequestDTO);
		String sessionToken = accountService.getSessionToken();
		//accountService.getAccountDetails();
		//accountService.getAccountFunds();
		
		//GET INFO FOR BETTING 
		bettingService.setSessionToken(sessionToken);
		bettingService.listEvents();
		
	}

}
