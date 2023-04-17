package betfairEx;

public class SingleOffer {
	private int eventId;
	private String marketId;
	private Double totalMatched;
	private Integer marketBookIndex;
	private String runner; //Team 1, Team 2 or Draw
	private Long selectionId; 
	private String bettingType;
	private Double price;
	private Double size;
	
	public int getEventId() {
		return eventId;
	}
	public String getMarketId() {
		return marketId;
	}
	public Double getTotalMatched() {
		return totalMatched;
	}
	public Integer getMarketBookIndex() {
		return marketBookIndex;
	}
	public String getRunner() {
		return runner;
	}
	public Long getSelectionId() {
		return selectionId;
	}
	public String getBettingType() {
		return bettingType;
	}
	public Double getPrice() {
		return price;
	}
	public Double getSize() {
		return size;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	public void setTotalMatched(Double totalMatched) {
		this.totalMatched = totalMatched;
	}
	public void setMarketBookIndex(Integer marketBookIndex) {
		this.marketBookIndex = marketBookIndex;
	}
	public void setRunner(String runner) {
		this.runner = runner;
	}
	public void setSelectionId(Long selectionId) {
		this.selectionId = selectionId;
	}
	public void setBettingType(String bettingType) {
		this.bettingType = bettingType;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return this.eventId + "; " + this.marketId + "; "  + this.totalMatched + "; " + this.marketBookIndex + "; " + this.runner + "; "
				 + this.selectionId + "; " + this.bettingType + "; " + this.price + "; " + this.size;
		
	}
	
	
	
	
	

}
