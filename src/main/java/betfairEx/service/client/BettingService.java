package betfairEx.service.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;
import betfairEx.dto.account.AccountFundsResponseDTO;
import betfairEx.dto.betting.EventsResponseDTO;
import betfairEx.dto.betting.MarketBookResponseDTO;
import betfairEx.dto.betting.MarketCatalogueResponseDTO;

public class BettingService {
	
	private static final String URL_BETTING_API_RPC = "https://api.betfair.com/exchange/betting/json-rpc/v1/SportsAPING/v1.0";
	
	
	private static final String ENDPOINT_LIST_EVENTS = "/listEvents";
	private static final String ENDPOINT_LIST_MARKET_CATALOGUE = "/listMarketCatalogue";
	private static final String ENDPOINT_LIST_MARKET_BOOK = "/listMarketBook";
	
	public static final String APPLICATION_KEY = "Kd8cCss5J3pcc5IM";
	
	private String sessionToken;

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public EventsResponseDTO listEvents() {
		try {
			HttpRequest postRequest = HttpRequest.newBuilder()
						.uri(new URI(URL_BETTING_API_RPC + ENDPOINT_LIST_EVENTS))
						.header("X-Application", APPLICATION_KEY)
						.header("X-Authentication", sessionToken )
						.POST(BodyPublishers.ofString("{\"jsonrpc\": \"2.0\", \"method\": \"SportsAPING/v1.0/listEvents\", \"params\": {\"filter\":{\"eventTypeIds\":[\"1\"],\"inPlayOnly\":true,\"marketTypeCodes\":[\"MATCH_ODDS\"]}}, \"id\": 1}"))
						.build();
			HttpClient httpClient = HttpClient.newHttpClient();
			System.out.println(postRequest);
			try {
				EventsResponseDTO eventsResponseDTO = new EventsResponseDTO();
				Gson gson = new Gson();
				HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
				//System.out.print(postResponse.body() + "\n");
				eventsResponseDTO = gson.fromJson(postResponse.body(), EventsResponseDTO.class);
				return eventsResponseDTO;	
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
		return null;
	}
	
	public MarketCatalogueResponseDTO listMarketCatalogue(String eventId) {
		try {
			String request = String.format("{\"jsonrpc\": \"2.0\", \"method\": \"SportsAPING/v1.0/listMarketCatalogue\", \"params\": {\"filter\":{\"eventIds\":[\"%s\"],\"marketTypeCodes\":[\"MATCH_ODDS\"]},\"maxResults\":\"100\"}, \"id\": 1}" 
							,eventId);
			HttpRequest postRequest = HttpRequest.newBuilder()
						.uri(new URI(URL_BETTING_API_RPC + ENDPOINT_LIST_MARKET_CATALOGUE))
						.header("X-Application", APPLICATION_KEY)
						.header("X-Authentication", sessionToken )
						.POST(BodyPublishers.ofString(request))
						.build();
			HttpClient httpClient = HttpClient.newHttpClient();
			System.out.println(postRequest);
			try {
				MarketCatalogueResponseDTO marketCatalogueResponseDTO = new MarketCatalogueResponseDTO();
				Gson gson = new Gson();
				HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
				//System.out.print(postResponse.body() + "\n");
				marketCatalogueResponseDTO = gson.fromJson(postResponse.body(), MarketCatalogueResponseDTO.class);
				return marketCatalogueResponseDTO;
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
		return null;
		
	}

	public MarketBookResponseDTO listMarketBook(String marketId) {
		try {
			String request = String.format("{\"jsonrpc\": \"2.0\", \"method\": \"SportsAPING/v1.0/listMarketBook\", \"params\": {\"currencyCode\":\"BRL\",\"marketIds\":[\"%s\"],\"priceProjection\":{\"priceData\":[\"EX_BEST_OFFERS\"],\"virtualise\":\"true\",\"exBestOffersOverrides\":{\"bestPricesDepth\":\"3\"}}}, \"id\": 1}" 
							,marketId);
			HttpRequest postRequest = HttpRequest.newBuilder()
						.uri(new URI(URL_BETTING_API_RPC + ENDPOINT_LIST_MARKET_BOOK))
						.header("X-Application", APPLICATION_KEY)
						.header("X-Authentication", sessionToken )
						.POST(BodyPublishers.ofString(request))
						.build();
			HttpClient httpClient = HttpClient.newHttpClient();
			System.out.println(postRequest);
			try {
				MarketBookResponseDTO marketBookResponseDTO = new MarketBookResponseDTO();
				Gson gson = new Gson();
				HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
				//System.out.print(postResponse.body() + "\n");
				marketBookResponseDTO = gson.fromJson(postResponse.body(), MarketBookResponseDTO.class);
				return marketBookResponseDTO;
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
		return null;
		
		
	}
}
