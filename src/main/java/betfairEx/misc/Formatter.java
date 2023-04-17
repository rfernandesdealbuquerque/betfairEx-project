package betfairEx.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import betfairEx.EventsBook;
import betfairEx.dto.betting.EventsResponseDTO;
import betfairEx.dto.betting.EventsResponseDTO.EventDTO;
import betfairEx.dto.betting.EventsResponseDTO.EventResultDTO;
import betfairEx.dto.betting.MarketBookResponseDTO;
import betfairEx.dto.betting.MarketBookResponseDTO.MarketBookDTO;
import betfairEx.dto.betting.MarketBookResponseDTO.RunnerDTO;
import betfairEx.enums.MarketType;
import betfairEx.model.Event;
import betfairEx.model.MarketBook;
import betfairEx.model.Runner;
import betfairEx.model.SingleOffer;

public class Formatter {
	
	public LinkedList<Event> formatEvents(EventsResponseDTO eventsResponseDTO){ //create list of event entities from response
		
		LinkedList<Event> myEvents = new LinkedList<Event>();
		
		for(EventResultDTO eventResultDTO : eventsResponseDTO.getResult()) {
			EventDTO eventDTO = eventResultDTO.getEvent();
			Event event = new Event();
			event.setId(Integer.valueOf(eventDTO.getId()));
			event.setName(eventDTO.getName());
			event.setOpenDate(eventDTO.getOpenDate());
			
			myEvents.add(event);
		}
		
		//System.out.print(myEvents);
		
		return myEvents;
		
	}
	
	public MarketBook formatMarketBook(MarketBookResponseDTO marketBookResponseDTO, String marketType) {
		
		MarketBookDTO marketBookDTO = marketBookResponseDTO.getResult().get(0);
		MarketBook marketBook = new MarketBook();
			
		marketBook.setMarketId(marketBookDTO.getMarketId());
		if(marketType.equals("Match Odds")){
			marketBook.setMarketType(MarketType.MATCH_ODDS);
		}
		marketBook.setIsMarketDataDelayed(marketBookDTO.isMarketDataDelayed());
		marketBook.setStatus(marketBookDTO.getStatus());
		marketBook.setInplay(marketBookDTO.isInplay());
		marketBook.setNumberOfWinners(marketBookDTO.getNumberOfWinners());
		marketBook.setNumberOfRunners(marketBookDTO.getNumberOfRunners());
		marketBook.setNumberOfActiveRunners(marketBookDTO.getNumberOfActiveRunners());
		marketBook.setTotalMatched(marketBookDTO.getTotalMatched());
		marketBook.setTotalAvailable(marketBookDTO.getTotalAvailable());
		
		List<Runner> runners = new ArrayList<Runner>();
		
		for(RunnerDTO runnerDTO : marketBookDTO.getRunners() ) {
			
			Runner runner = new Runner();
			
			runner.setSelectionId(runnerDTO.getSelectionId());
			runner.setHandicap(runnerDTO.getHandicap());
			runner.setStatus(runnerDTO.getStatus());
			runner.setLastPriceTraded(runnerDTO.getLastPriceTraded());
			runner.setTotalMatched(runnerDTO.getTotalMatched());
			runner.setEx(runnerDTO.getEx());
			
			runners.add(runner);
		
		}
		
		marketBook.setRunners(runners);
		
		return marketBook;
		
	}
	
}