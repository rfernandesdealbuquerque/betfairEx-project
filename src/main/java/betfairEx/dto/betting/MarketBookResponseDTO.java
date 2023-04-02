package betfairEx.dto.betting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarketBookResponseDTO {
	
	private String jsonrpc;
	private List<MarketBookDTO> result;
	private int id;
	
	public String getJsonrpc() {
		return jsonrpc;
	}

	public List<MarketBookDTO> getResult() {
		return result;
	}

	public int getId() {
		return id;
	}

	public class MarketBookDTO {
		private String marketId;
		private boolean isMarketDataDelayed;
		private MarketStatusDTO status;
		private int betDelay;
		private boolean bspReconciled;
		private boolean complete;
		private boolean inplay;
		private int numberOfWinners;
		private int numberOfRunners;
		private int numberOfActiveRunners;
		private Date lastMatchTime;
		private double totalMatched;
		private double totalAvailable;
		private boolean crossMatching;
		private boolean runnersVoidable;
		private long version;
		private List<RunnerDTO> runners;
		
		public String getMarketId() {
			return marketId;
		}
		public boolean isMarketDataDelayed() {
			return isMarketDataDelayed;
		}
		public MarketStatusDTO getStatus() {
			return status;
		}
		public int getBetDelay() {
			return betDelay;
		}
		public boolean isBspReconciled() {
			return bspReconciled;
		}
		public boolean isComplete() {
			return complete;
		}
		public boolean isInplay() {
			return inplay;
		}
		public int getNumberOfWinners() {
			return numberOfWinners;
		}
		public int getNumberOfRunners() {
			return numberOfRunners;
		}
		public int getNumberOfActiveRunners() {
			return numberOfActiveRunners;
		}
		public Date getLastMatchTime() {
			return lastMatchTime;
		}
		public double getTotalMatched() {
			return totalMatched;
		}
		public double getTotalAvailable() {
			return totalAvailable;
		}
		public boolean isCrossMatching() {
			return crossMatching;
		}
		public boolean isRunnersVoidable() {
			return runnersVoidable;
		}
		public long getVersion() {
			return version;
		}
		public List<RunnerDTO> getRunners() {
			return runners;
		}
		
	
	}
	
	public enum MarketStatusDTO{
		INACTIVE,
		OPEN,
		SUSPENDED,
		CLOSED
	}
	
	public class RunnerDTO{ //Runner is the result you are backing. E.g. team 1 victory is a runner, team 2 victory is another runner and draw is a third runner
		private long selectionId;
		private double handicap;
		private RunnerStatusDTO status;
		private double lastPriceTraded;
		private double totalMatched;
		private ExchangePricesDTO ex;
		
		public long getSelectionId() {
			return selectionId;
		}
		public double getHandicap() {
			return handicap;
		}
		public RunnerStatusDTO getStatus() {
			return status;
		}
		public double getLastPriceTraded() {
			return lastPriceTraded;
		}
		public double getTotalMatched() {
			return totalMatched;
		}
		public ExchangePricesDTO getEx() {
			return ex;
		}
		
		
	
	}
	
	public enum RunnerStatusDTO{
		ACTIVE,
		WINNER,
		LOSER,
		PLACED,
		REMOVE_VACANT,
		REMOVED,
		HIDDEN
	}
	
	public class ExchangePricesDTO{
		private List<PriceSizeDTO> availableToBack;
		private List<PriceSizeDTO> availableToLay;
		private List<PriceSizeDTO> tradedVolume;
		
		public List<PriceSizeDTO> getAvailableToBack() {
			return availableToBack;
		}
		public List<PriceSizeDTO> getAvailableToLay() {
			return availableToLay;
		}
		public List<PriceSizeDTO> getTradedVolume() {
			return tradedVolume;
		}
		
		
	}
	
	public class PriceSizeDTO{
		private double price;
		private double size;
		
		public double getPrice() {
			return price;
		}
		public double getSize() {
			return size;
		}
		
		
	}
	

}
