package betfairEx.dto.betting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import betfairEx.enums.MarketStatus;
import betfairEx.enums.RunnerStatus;
import betfairEx.model.ExchangePrices;

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
		private MarketStatus status;
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
		public MarketStatus getStatus() {
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
	
	
	public class RunnerDTO{ //Runner is the result you are backing. E.g. team 1 victory is a runner, team 2 victory is another runner and draw is a third runner
		private long selectionId;
		private double handicap;
		private RunnerStatus status;
		private double lastPriceTraded;
		private double totalMatched;
		private ExchangePrices ex;
		
		public long getSelectionId() {
			return selectionId;
		}
		public double getHandicap() {
			return handicap;
		}
		public RunnerStatus getStatus() {
			return status;
		}
		public double getLastPriceTraded() {
			return lastPriceTraded;
		}
		public double getTotalMatched() {
			return totalMatched;
		}
		public ExchangePrices getEx() {
			return ex;
		}
			
	
	}
	

}
