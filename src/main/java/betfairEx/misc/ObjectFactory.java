package betfairEx.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import betfairEx.EventsBook;
import betfairEx.model.Event;
import betfairEx.model.MarketBook;
import betfairEx.model.SingleOffer;

public class ObjectFactory {
	
	public List<List<SingleOffer>> makeOffersLists(EventsBook myEventsBook, Event event, String runner){
		LinkedList<SingleOffer> listTeam1 = new LinkedList<SingleOffer>();
		LinkedList<SingleOffer> listTeam2 = new LinkedList<SingleOffer>();
		LinkedList<SingleOffer> listDraw = new LinkedList<SingleOffer>();
		ArrayList<List<SingleOffer>> offersLists = new ArrayList<List<SingleOffer>>();
		
		List<MarketBook> marketsBook = myEventsBook.getMyEventsBook().get(event);
		
		int eventId = event.getId();
		String marketId = marketsBook.get(0).getMarketId();
		
		for (int i=0; i<marketsBook.size(); i++) {
			MarketBook marketBook = marketsBook.get(i);
			Double totalMatched = marketBook.getTotalMatched();
			Integer marketBookIndex = i;
			
			for (int k=0; k<marketBook.getRunners().size(); k++) { //will run 3 times
					
				
			
			}
		}
		
		
		
		return null;
		
	}

}
