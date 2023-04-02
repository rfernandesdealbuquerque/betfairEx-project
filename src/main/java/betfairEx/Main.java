package betfairEx;

import java.util.HashMap;
import java.util.List;

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
		EventsResponseDTO eventResponseDTO = bettingService.listEvents();
		process.processEvents(myEventsBook, eventResponseDTO);
		for(Event event : myEventsBook.keySet()) {
			Integer eventId = (Integer) event.getId();
			MarketCatalogueResponseDTO market = bettingService.listMarketCatalogue(eventId.toString());
			String marketId = market.getResult().get(0).getMarketId();
			MarketBookResponseDTO marketBookResponseDTO = bettingService.listMarketBook(marketId);
			process.processMarketBook(marketBookResponseDTO, eventId, myEventsBook); //format marketBook the way Otavio needs, add to map
			//TO DO: create MarketBookResponse, create listMarketBook, create processMarketBook
			
			break;
		
		}
		
		//System.out.print(myEventsBook);
		
		
	}

}
