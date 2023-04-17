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
import betfairEx.enums.MarketStatus;
import betfairEx.enums.MarketType;
import betfairEx.misc.Formatter;
import betfairEx.model.Event;
import betfairEx.model.MarketBook;
import betfairEx.model.PriceSize;
import betfairEx.model.Runner;

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
		
		HashMap<Event, List<MarketBook>> myEventsBook = this.myEventsBook;
		if(!marketBook.getStatus().equals(MarketStatus.OPEN)) {
			return;
		}
		
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
	
	public void printMyEventsBook() {
		for (Event event : myEventsBook.keySet()) {
			List<MarketBook> marketsBook = myEventsBook.get(event);
			System.out.printf("event: %s \n", event.getName());
			System.out.printf("id: %s \n", event.getId());
			if(marketsBook.size() == 0){
				continue;
			}
			System.out.printf("market id: %s \n", marketsBook.get(marketsBook.size()-1).getMarketId());
			System.out.printf("inPlay: %s \n", marketsBook.get(marketsBook.size()-1).getInplay());
			System.out.printf("total matched: R$%f \n", marketsBook.get(marketsBook.size()-1).getTotalMatched()); //total matched on last market book added - the one added to the end
			System.out.print("MarketBook size: " + marketsBook.size() + "\n");
			
			for (int i = 0; i<marketsBook.size(); i++) {
				System.out.printf("(%d) \n", i+1);
				System.out.printf("-------------------------------------------------------   ATB      |      ATL  -------------------------------------------------- \n");
				for (Runner runner : marketsBook.get(i).getRunners()) {
					for(int k = 0; k<runner.getEx().getAvailableToBack().size(); k++) {
						Double atbPrice = runner.getEx().getAvailableToBack().get(k).getPrice();
						Double atbSize = runner.getEx().getAvailableToBack().get(k).getSize();
						System.out.printf("%.2f:R$%-10.0f  ", atbPrice, atbSize);
					}
					System.out.printf("|    ");
					for(int k = 0; k<runner.getEx().getAvailableToLay().size(); k++) {
						Double atlPrice = runner.getEx().getAvailableToLay().get(k).getPrice();
						Double atlSize = runner.getEx().getAvailableToLay().get(k).getSize();
						System.out.printf("%.2f:R$%-10.0f  ", atlPrice, atlSize);
					}
					System.out.printf("selectionId: %s", runner.getSelectionId().toString());
					System.out.printf("\n");
					
				}
				System.out.printf("--------------------------------------------------------------------------------------------------------------------------------- \n");
				
			}
			
			
			
		}
	}


}
