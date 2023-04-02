package betfairEx.dto.betting;

import java.util.ArrayList;

public class MarketCatalogueResponseDTO {
	
	private String jsonrpc;
	private ArrayList<MarketDTO> result;
	private int id;
	
	public String getJsonrpc() {
		return jsonrpc;
	}

	public ArrayList<MarketDTO> getResult() {
		return result;
	}

	public int getId() {
		return id;
	}

	public class MarketDTO{
		private String marketId;
		private String marketName;
		private double totalMatched;
		
		public String getMarketId() {
			return marketId;
		}
		public String getMarketName() {
			return marketName;
		}
		public double getTotalMatched() {
			return totalMatched;
		}
		
		
		
		
	}

}
