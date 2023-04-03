package betfairEx;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import betfairEx.dto.betting.EventsResponseDTO;
import betfairEx.dto.betting.MarketBookResponseDTO;
import betfairEx.dto.betting.EventsResponseDTO.EventDTO;
import betfairEx.dto.betting.EventsResponseDTO.EventResultDTO;
import betfairEx.dto.betting.MarketBookResponseDTO.MarketBookDTO;
import betfairEx.dto.betting.MarketBookResponseDTO.RunnerDTO;
import betfairEx.enums.MarketType;
import betfairEx.model.Event;
import betfairEx.model.MarketBook;
import betfairEx.model.Runner;
import betfairEx.service.Formatter;

public class EventsBook {
	
	private HashMap<Event, List<MarketBook>> myEventsBook;
	
	public EventsBook() {
		this.myEventsBook = new HashMap<Event, List<MarketBook>>();
	}

	public HashMap<Event, List<MarketBook>> getMyEventsBook() {
		return myEventsBook;
	}

	public void setMyEventsBook(HashMap<Event, List<MarketBook>> myEventsBook) {
		this.myEventsBook = myEventsBook;
	}
	
	
	public void addEvent(LinkedList<Event> myEvents) {
		for (Event event : myEvents) {
			if (!this.getMyEventsBook().containsKey(event)) { //add only event that do not exist already
				this.getMyEventsBook().put(event, new LinkedList<MarketBook>());
			} //fiquei 2 horas desbugando essa bosta porque esqueci de por as chaves em volta do if, eai a lista sempre zerava- AFF
		}
	}
	
	public void processNewEvents(EventsResponseDTO eventResponseDTO) {
		Formatter formatter = new Formatter();
		LinkedList<Event> myEvents = formatter.formatEvents(eventResponseDTO);
		this.addEvent(myEvents);
	}
	
	
	
	
	public void addMarketBook(Event event, MarketBook marketBook) {
		
		HashMap<Event, List<MarketBook>> myEventsBook = this.getMyEventsBook();
		if(myEventsBook.get(event).size() < 3) {
			
			LinkedList<MarketBook> myUpdatedList = (LinkedList<MarketBook>) myEventsBook.get(event);
			myUpdatedList.add(marketBook);
			myEventsBook.put(event, myUpdatedList);
			

		}
		else {
			myEventsBook.get(event).remove(0);
			myEventsBook.get(event).add(marketBook);
		}
	}
	

	public void processNewMarketBook(MarketBookResponseDTO marketBookResponseDTO, Event event, String marketType) {
		// TODO Auto-generated method stub
		Formatter formatter = new Formatter();
		MarketBook marketBook = formatter.formatMarketBook(marketBookResponseDTO, marketType);
		addMarketBook(event, marketBook);
		
	}


}
