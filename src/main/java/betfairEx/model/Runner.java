package betfairEx.model;

public class Runner {
	private Long selectionId;
	private Double handicap;
	private RunnerStatus status;
	private Double lastPriceTraded;
	private Double totalMatched;
	private ExchangePrices ex;
	
	public Long getSelectionId() {
		return selectionId;
	}
	public Double getHandicap() {
		return handicap;
	}
	public RunnerStatus getStatus() {
		return status;
	}
	public Double getLastPriceTraded() {
		return lastPriceTraded;
	}
	public Double getTotalMatched() {
		return totalMatched;
	}
	public ExchangePrices getEx() {
		return ex;
	}
	public void setSelectionId(Long selectionId) {
		this.selectionId = selectionId;
	}
	public void setHandicap(Double handicap) {
		this.handicap = handicap;
	}
	public void setStatus(RunnerStatus status) {
		this.status = status;
	}
	public void setLastPriceTraded(Double lastPriceTraded) {
		this.lastPriceTraded = lastPriceTraded;
	}
	public void setTotalMatched(Double totalMatched) {
		this.totalMatched = totalMatched;
	}
	public void setEx(ExchangePrices ex) {
		this.ex = ex;
	}
	
	


}
