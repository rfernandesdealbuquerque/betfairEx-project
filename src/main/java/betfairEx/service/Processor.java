package betfairEx.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import betfairEx.dto.betting.EventsResponseDTO;
import betfairEx.dto.betting.EventsResponseDTO.EventDTO;
import betfairEx.dto.betting.EventsResponseDTO.EventResultDTO;
import betfairEx.dto.betting.MarketBookResponseDTO;
import betfairEx.model.Event;
import betfairEx.model.MarketBook;

public class Processor {
	
	public LinkedList<Event> formatEvents(EventsResponseDTO eventsResponseDTO){
		
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
	
	public void addToEventsBook(HashMap<Event, List<MarketBook>> myEventsBook, LinkedList<Event> myEvents) {
		for (Event event : myEvents) {
			myEventsBook.put(event, null);
		}
	}
	
	public void processEvents(HashMap<Event, List<MarketBook>> myEventsBook, EventsResponseDTO eventResponseDTO) {
		LinkedList<Event> myEvents = formatEvents(eventResponseDTO);
		addToEventsBook(myEventsBook, myEvents);
	}
	
	
	public MarketBook formatMarketBook(MarketBookResponseDTO marketBookResponseDTO) {
		
		
		
		return null;
		
	}
	

	public void processMarketBook(MarketBookResponseDTO marketBook, Integer eventId, HashMap<Event, List<MarketBook>> myEventsBook) {
		// TODO Auto-generated method stub
		
	}


}
