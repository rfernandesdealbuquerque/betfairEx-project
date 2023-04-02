package betfairEx.model;

public enum MarketType {
	MATCH_ODDS ("Match Odds"),
	OVER_UNDER_15("Over/Under 3.5 Goals"),
	CORRECT_SCORE("Correct Score"),
	DOUBLE_CHANCE("Double Chance");

	private String marketType;
	
	private MarketType(String marketType) {
		this.marketType = marketType;
	}
	
	private String getMarketType() {
		return this.marketType;
	}
	
}
