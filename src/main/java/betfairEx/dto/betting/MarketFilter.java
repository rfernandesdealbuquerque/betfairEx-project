package betfairEx.dto.betting;


import java.util.Date;
import java.util.Set;

public class MarketFilter {
	private String textQuery;
	private Set <String> eventTypeIds;
	private Set <String> eventIds;
	private Set <String> competitionIds;
	private Set <String> marketIds;
	private Set <String> venues;
	private boolean bspOnly;
	private boolean turnInPlayEnabled;
	private boolean inPlayOnly;
	private Set <MarketBettingType> marketBettingTypes;
	private Set <String> marketCountries;
	private Set<String> marketTypeCodes;
	private TimeRange marketStartTime;
	private Set <OrderStatus> withOrders;
	private String raceTypes;
	
	public String getTextQuery() {
		return textQuery;
	}

	public Set<String> getEventTypeIds() {
		return eventTypeIds;
	}

	public Set<String> getEventIds() {
		return eventIds;
	}

	public Set<String> getCompetitionIds() {
		return competitionIds;
	}

	public Set<String> getMarketIds() {
		return marketIds;
	}

	public Set<String> getVenues() {
		return venues;
	}

	public boolean isBspOnly() {
		return bspOnly;
	}

	public boolean isTurnInPlayEnabled() {
		return turnInPlayEnabled;
	}

	public boolean isInPlayOnly() {
		return inPlayOnly;
	}

	public Set<MarketBettingType> getMarketBettingTypes() {
		return marketBettingTypes;
	}

	public Set<String> getMarketCountries() {
		return marketCountries;
	}

	public Set<String> getMarketTypeCodes() {
		return marketTypeCodes;
	}

	public TimeRange getMarketStartTime() {
		return marketStartTime;
	}

	public Set<OrderStatus> getWithOrders() {
		return withOrders;
	}

	public String getRaceTypes() {
		return raceTypes;
	}

	public void setTextQuery(String textQuery) {
		this.textQuery = textQuery;
	}

	public void setEventTypeIds(Set<String> eventTypeIds) {
		this.eventTypeIds = eventTypeIds;
	}

	public void setEventIds(Set<String> eventIds) {
		this.eventIds = eventIds;
	}

	public void setCompetitionIds(Set<String> competitionIds) {
		this.competitionIds = competitionIds;
	}

	public void setMarketIds(Set<String> marketIds) {
		this.marketIds = marketIds;
	}

	public void setVenues(Set<String> venues) {
		this.venues = venues;
	}

	public void setBspOnly(boolean bspOnly) {
		this.bspOnly = bspOnly;
	}

	public void setTurnInPlayEnabled(boolean turnInPlayEnabled) {
		this.turnInPlayEnabled = turnInPlayEnabled;
	}

	public void setInPlayOnly(boolean inPlayOnly) {
		this.inPlayOnly = inPlayOnly;
	}

	public void setMarketBettingTypes(Set<MarketBettingType> marketBettingTypes) {
		this.marketBettingTypes = marketBettingTypes;
	}

	public void setMarketCountries(Set<String> marketCountries) {
		this.marketCountries = marketCountries;
	}

	public void setMarketTypeCodes(Set<String> marketTypeCodes) {
		this.marketTypeCodes = marketTypeCodes;
	}

	public void setMarketStartTime(TimeRange marketStartTime) {
		this.marketStartTime = marketStartTime;
	}

	public void setWithOrders(Set<OrderStatus> withOrders) {
		this.withOrders = withOrders;
	}

	public void setRaceTypes(String raceTypes) {
		this.raceTypes = raceTypes;
	}

	private enum MarketBettingType{
		ODDS,
		LINE,
		RANGE,
		ASIAN_HANDICAP_DOUBLE_LINE,
		ASIAN_HANDICAP_SINGLE_LINE,
	}
	
	private class TimeRange{
		Date from;
		Date to;
	}
	
	

}
