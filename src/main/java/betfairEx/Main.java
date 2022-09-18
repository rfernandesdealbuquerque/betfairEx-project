package betfairEx;

import betfairEx.dto.LoginRequestDTO;
import betfairEx.service.AccountService;

public class Main {
	public static void main(String[] args) throws Exception {
		
		AccountService accountService = new AccountService();
		LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
		
		loginRequestDTO.setUsername("rodrig20002012@gmail.com");
		loginRequestDTO.setPassword("Futebol@27");
		
		accountService.login(loginRequestDTO);
	}

}
