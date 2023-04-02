package betfairEx;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import betfairEx.dto.account.AccountDetailsResponseDTO;
import betfairEx.dto.betting.EventsResponseDTO;
import betfairEx.dto.betting.MarketBookResponseDTO;
import betfairEx.dto.betting.MarketCatalogueResponseDTO;
import betfairEx.dto.login.LoginRequestDTO;
import betfairEx.model.Event;
import betfairEx.model.MarketBook;
import betfairEx.service.Processor;
import betfairEx.service.client.AccountService;
import betfairEx.service.client.BettingService;

//PROJECT GITHUB PERSONAL TOKEN: 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

public class Main {
	public static void main(String[] args) throws Exception {
		
		HashMap<Event, List<MarketBook>> myEventsBook = new HashMap<Event, List<MarketBook>>();
		
		AccountService accountService = new AccountService();
		LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
		BettingService bettingService = new BettingService();
		Processor process = new Processor();
		
		//LOGIN
		loginRequestDTO.setUsername("rodrig20002012@gmail.com");
		loginRequestDTO.setPassword("Futebol@27");
		
		//GET ACCOUNT INFO
		String sessionToken = accountService.login(loginRequestDTO);
		//accountService.getAccountDetails();
		//accountService.getAccountFunds();
		
		//GET INFO FOR BETTING 
		bettingService.setSessionToken(sessionToken);
		while(true) {
			EventsResponseDTO eventResponseDTO = bettingService.listEvents();
			process.processEvents(myEventsBook, eventResponseDTO);
			for(Event event : myEventsBook.keySet()) {
				Integer eventId = (Integer) event.getId();
				MarketCatalogueResponseDTO market = bettingService.listMarketCatalogue(eventId.toString());
				if(market.getResult().size() == 0) { //if event doesn't have market of type MATCH_ODDS
					continue;
				}
				String marketId = market.getResult().get(0).getMarketId();
				MarketBookResponseDTO marketBookResponseDTO = bettingService.listMarketBook(marketId);
				process.processMarketBook(marketBookResponseDTO, event, marketId, myEventsBook); //add new market book to myEventsBook - keep only 10 most recent market books for each event			
				
				// THERE'S SOMETHING WRONG - ADDING DUPLICATES - CHECK HASHCODE
				
				System.out.print(eventId + " " + myEventsBook.get(event).size() + " ");
				
				if(myEventsBook.get(event).size()==2) {
					runAlgorithm(eventId);
				}
		
			}
			TimeUnit.SECONDS.sleep(10);
		}
		
		//System.out.print(myEventsBook);
		
		
	}
	
	public static String runAlgorithm(Integer eventId) {
		return "Running algorithm on event" + eventId;
		
	}

}
