package betfairEx.model;

import java.util.List;

public class ExchangePrices {
	private List<PriceSize> availableToBack;
	private List<PriceSize> availableToLay;
	
	public List<PriceSize> getAvailableToBack() {
		return availableToBack;
	}
	public List<PriceSize> getAvailableToLay() {
		return availableToLay;
	}
	public void setAvailableToBack(List<PriceSize> availableToBack) {
		this.availableToBack = availableToBack;
	}
	public void setAvailableToLay(List<PriceSize> availableToLay) {
		this.availableToLay = availableToLay;
	}
	
	
}
