package betfairEx.service.extract;

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

public class BettingService {
	
	private static final String URL_BETTING_API_RPC = "https://api.betfair.com/exchange/betting/json-rpc/v1/SportsAPING/v1.0";
	
	
	private static final String ENDPOINT_LIST_EVENTS = "/listEvents";
	public static final String APPLICATION_KEY = "Kd8cCss5J3pcc5IM";
	
	private String sessionToken;

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public void listEvents() {
		try {
			HttpRequest postRequest = HttpRequest.newBuilder()
						.uri(new URI(URL_BETTING_API_RPC + ENDPOINT_LIST_EVENTS))
						.header("X-Application", APPLICATION_KEY)
						.header("X-Authentication", sessionToken )
						.POST(BodyPublishers.ofString("{\"jsonrpc\": \"2.0\", \"method\": \"SportsAPING/v1.0/listEvents\", \"params\": {\"filter\":{\"eventTypeIds\":[\"1\"],\"inPlayOnly\":true}}, \"id\": 1}"))
						.build();
			HttpClient httpClient = HttpClient.newHttpClient();
			System.out.println(postRequest);
			try {
				EventsResponseDTO eventsResponseDTO = new EventsResponseDTO();
				Gson gson = new Gson();
				HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
				System.out.print(postResponse.body() + "\n");
				//eventsResponseDTO = gson.fromJson(postResponse.body(), EventsResponseDTO.class);
				//System.out.println(eventsResponseDTO);
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
