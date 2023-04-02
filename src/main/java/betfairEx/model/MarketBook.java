package betfairEx.model;

import java.util.List;

public class MarketBook {
	private String marketId;
	private MarketType marketType;
	private Boolean isMarketDataDelayed;
	private MarketStatus status;
	private Boolean inplay;
	private Integer totalMatched;
	private Integer totalAvailable;
	private Integer numberOfWinners;
	private Integer numberOfRunners;
	private Integer numberOfActiveRunners;
	private List<Runner> runners;
	
	public String getMarketId() {
		return marketId;
	}
	public MarketType getMarketType() {
		return marketType;
	}
	public Boolean getIsMarketDataDelayed() {
		return isMarketDataDelayed;
	}
	public MarketStatus getStatus() {
		return status;
	}
	public Boolean getInplay() {
		return inplay;
	}
	public Integer getTotalMatched() {
		return totalMatched;
	}
	public Integer getTotalAvailable() {
		return totalAvailable;
	}
	public Integer getNumberOfWinners() {
		return numberOfWinners;
	}
	public Integer getNumberOfRunners() {
		return numberOfRunners;
	}
	public Integer getNumberOfActiveRunners() {
		return numberOfActiveRunners;
	}
	public List<Runner> getRunners() {
		return runners;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	public void setMarketType(MarketType marketType) {
		this.marketType = marketType;
	}
	public void setIsMarketDataDelayed(Boolean isMarketDataDelayed) {
		this.isMarketDataDelayed = isMarketDataDelayed;
	}
	public void setStatus(MarketStatus status) {
		this.status = status;
	}
	public void setInplay(Boolean inplay) {
		this.inplay = inplay;
	}
	public void setTotalMatched(Integer totalMatched) {
		this.totalMatched = totalMatched;
	}
	public void setTotalAvailable(Integer totalAvailable) {
		this.totalAvailable = totalAvailable;
	}
	public void setNumberOfWinners(Integer numberOfWinners) {
		this.numberOfWinners = numberOfWinners;
	}
	public void setNumberOfRunners(Integer numberOfRunners) {
		this.numberOfRunners = numberOfRunners;
	}
	public void setNumberOfActiveRunners(Integer numberOfActiveRunners) {
		this.numberOfActiveRunners = numberOfActiveRunners;
	}
	public void setRunners(List<Runner> runners) {
		this.runners = runners;
	}
	
	
	
	

}
