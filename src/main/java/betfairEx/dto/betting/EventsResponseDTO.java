package betfairEx.dto.betting;

import java.util.Date;

public class EventsResponseDTO {
	private String jsonrpc;
	private EventResult result;
	private int id;
	
	public String getJsonrpc() {
		return jsonrpc;
	}

	public EventResult getResult() {
		return result;
	}

	public int getId() {
		return id;
	}

	private class EventResult{
		private Event event;
		private int marketCount;
		
		public Event getEvent() {
			return event;
		}
		public int getMarketCount() {
			return marketCount;
		}
		
	}
	
	private class Event{
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
