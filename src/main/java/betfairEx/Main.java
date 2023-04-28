package betfairEx;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import betfairEx.client.AccountService;
import betfairEx.client.BettingService;
import betfairEx.dto.account.AccountDetailsResponseDTO;
import betfairEx.dto.betting.EventsResponseDTO;
import betfairEx.dto.betting.MarketBookResponseDTO;
import betfairEx.dto.betting.MarketCatalogueResponseDTO;
import betfairEx.dto.login.LoginRequestDTO;
import betfairEx.misc.Formatter;
import betfairEx.misc.ObjectFactory;
import betfairEx.model.Event;
import betfairEx.model.MarketBook;
import betfairEx.model.SingleOffer;

//PROJECT GITHUB PERSONAL TOKEN: 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

public class Main {
	public static void main(String[] args) throws Exception {
		
		EventsBook myEventsBook = new EventsBook();
		
		AccountService accountService = new AccountService();
		LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
		BettingService bettingService = new BettingService();
		ObjectFactory objectFactory = new ObjectFactory();
		
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
			myEventsBook.processNewEvents(eventResponseDTO); //format API response and add new events to events book
			
			//IMPLEMENT A LIST OF EVENT IDs SORTED BY TOTAL_MATCHED and a MECHANISM TO RECYCLE EVENTS BOOK (delete games not in play and update total_matched values for each game)
	
			for(Event event : myEventsBook.getMyEventsBook().keySet()) { //for each event, get current market book
				Integer eventId = (Integer) event.getId();
				MarketCatalogueResponseDTO market = bettingService.listMarketCatalogue(eventId.toString());
				if(market.getResult().size() == 0) { //if event doesn't have market of type MATCH_ODDS
					continue;
				}
				String marketId = market.getResult().get(0).getMarketId();
				MarketBookResponseDTO marketBookResponseDTO = bettingService.listMarketBook(marketId);
				myEventsBook.processNewMarketBook(marketBookResponseDTO, event, marketId); //add new market book to the corresponding event in myEventsBook - keep only 3 most recent market books for each event			
						
				List<MarketBook> myCurrentMarketsBook = myEventsBook.getMyEventsBook().get(event);
				if(myCurrentMarketsBook.size() == 3) { 
					List<SingleOffer> offersList = objectFactory.makeOffersList(myCurrentMarketsBook, eventId); //go through the last n market books and create one centralized list with SingleOffer objects
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
