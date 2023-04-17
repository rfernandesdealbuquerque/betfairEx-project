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
import betfairEx.service.Formatter;
import betfairEx.service.client.AccountService;
import betfairEx.service.client.BettingService;

//PROJECT GITHUB PERSONAL TOKEN: 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

public class Main {
	public static void main(String[] args) throws Exception {
		
		EventsBook myEventsBook = new EventsBook();
		
		AccountService accountService = new AccountService();
		LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
		BettingService bettingService = new BettingService();
		
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
			myEventsBook.processNewEvents(eventResponseDTO);
	
			for(Event event : myEventsBook.getMyEventsBook().keySet()) {
				Integer eventId = (Integer) event.getId();
				MarketCatalogueResponseDTO market = bettingService.listMarketCatalogue(eventId.toString());
				if(market.getResult().size() == 0) { //if event doesn't have market of type MATCH_ODDS
					continue;
				}
				String marketId = market.getResult().get(0).getMarketId();
				MarketBookResponseDTO marketBookResponseDTO = bettingService.listMarketBook(marketId);
				myEventsBook.processNewMarketBook(marketBookResponseDTO, event, marketId); //add new market book to myEventsBook - keep only 3 most recent market books for each event			
						
				if(myEventsBook.getMyEventsBook().get(event).size()== 3) {
					System.out.print(runAlgorithm(eventId));
				}
				
			}
			//for(Event event : myEventsBook.getMyEventsBook().keySet()) {
				//System.out.print("End of round " + event.getId() + " " + myEventsBook.getMyEventsBook().get(event).size() + "\n");
			//}
			
			myEventsBook.printMyEventsBook();
			
			TimeUnit.SECONDS.sleep(5);
			
			
		} //TO DO: print map formatted to verify if everything is good. 
		
		//System.out.print(myEventsBook);
		
		
		
	}
	
	public static String runAlgorithm(Integer eventId) {
		return "Running algorithm on event " + eventId + "\n";
		
	}

}
