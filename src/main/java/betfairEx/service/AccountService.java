package betfairEx.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import betfairEx.dto.AccountDetailsResponseDTO;
import betfairEx.dto.AccountFundsResponseDTO;
import betfairEx.dto.LoginRequestDTO;
import betfairEx.dto.LoginResponseDTO;

public class AccountService {
	
	private static final String URL_INTERACTIVE_LOGIN_API = "https://identitysso.betfair.com/api/login"; 
	private static final String URL_ACCOUNTS_API_REST = "https://api.betfair.com/exchange/account/rest/v1.0";
	private static final String URL_ACCOUNTS_API_RPC = "https://api.betfair.com/exchange/account/json-rpc/v1/AccountAPING/v1.0";
	
	private static final String ENDPOINT_GET_KEYS = "/getDeveloperAppKeys";
	private static final String ENDPOINT_GET_ACCOUNT_DETAILS = "/getAccountDetails/";
	private static final String ENDPOINT_GET_ACCOUNT_FUNDS = "/getAccountFunds";
	
	private static final String APPLICATION_KEY = "Kd8cCss5J3pcc5IM";
	
	public String sessionToken;
	
	
	public void login(LoginRequestDTO loginRequestDTO) {
		
		try {
			HttpRequest postRequest = HttpRequest.newBuilder()
					.uri(new URI(URL_INTERACTIVE_LOGIN_API))
					.header("Accept", "application/json" )
					.header("Content-Type", "application/x-www-form-urlencoded")
					.header("X-Application", APPLICATION_KEY)
					.POST(BodyPublishers.ofString("username=" + loginRequestDTO.getUsername()+ "&password=" + loginRequestDTO.getPassword()))
					.build();
			HttpClient httpClient = HttpClient.newHttpClient();
			System.out.println(postRequest);
			try {
				LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
				Gson gson = new Gson();
				HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
				loginResponseDTO = gson.fromJson(postResponse.body(), LoginResponseDTO.class);
				sessionToken = loginResponseDTO.getToken();
				System.out.println(loginResponseDTO);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void getAccountDetails() {
		try {
			HttpRequest getRequest = HttpRequest.newBuilder()
					.uri(new URI(URL_ACCOUNTS_API_REST + ENDPOINT_GET_ACCOUNT_DETAILS))
					.header("Accept", "application/json" )
					//.header("Content-Type", "application/x-www-form-urlencoded")
					.header("X-Application", APPLICATION_KEY)
					.header("X-Authentication", sessionToken)
					.GET()
					.build();
			HttpClient httpClient = HttpClient.newHttpClient();
			System.out.println(getRequest);
			try {
				AccountDetailsResponseDTO accountDetailsResponseDTO = new AccountDetailsResponseDTO();
				Gson gson = new Gson();
				HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
				//System.out.print(getResponse.body() + "\n");
				accountDetailsResponseDTO = gson.fromJson(getResponse.body(), AccountDetailsResponseDTO.class);
				System.out.println(accountDetailsResponseDTO);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public void getAccountFunds() {
		try {
		HttpRequest postRequest = HttpRequest.newBuilder()
					.uri(new URI(URL_ACCOUNTS_API_RPC + ENDPOINT_GET_ACCOUNT_FUNDS))
					.header("X-Application", APPLICATION_KEY)
					.header("X-Authentication", sessionToken)
					.POST(BodyPublishers.ofString("{\"jsonrpc\": \"2.0\",\"method\": \"AccountAPING/v1.0/getAccountFunds\",\"params\": {\"wallet\": \"UK\"},\"id\": 1}"))
					.build();
		HttpClient httpClient = HttpClient.newHttpClient();
		System.out.println(postRequest);
		try {
			AccountFundsResponseDTO accountFundsResponseDTO = new AccountFundsResponseDTO();
			Gson gson = new Gson();
			HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
			//System.out.print(postResponse.body() + "\n");
			accountFundsResponseDTO = gson.fromJson(postResponse.body(), AccountFundsResponseDTO.class);
			System.out.println(accountFundsResponseDTO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
  }
}