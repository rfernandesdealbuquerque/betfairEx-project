package betfairEx.dto.betting;

import java.util.ArrayList;
import java.util.Date;

public class EventsResponseDTO {
	private String jsonrpc;
	private ArrayList<EventResultDTO> result;
	private int id;
	
	public String getJsonrpc() {
		return jsonrpc;
	}

	public ArrayList<EventResultDTO> getResult() {
		return result;
	}

	public int getId() {
		return id;
	}

	public class EventResultDTO{
		private EventDTO event;
		private int marketCount;
		
		public EventDTO getEvent() {
			return event;
		}
		public int getMarketCount() {
			return marketCount;
		}
		
	}
	
	public class EventDTO{
		private String id;
		private String name;
		private String countryCode;
		private String timezone;
		private Date openDate;
		
		public String getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public String getCountryCode() {
			return countryCode;
		}
		public String getTimezone() {
			return timezone;
		}
		public Date getOpenDate() {
			return openDate;
		}
	}
}
