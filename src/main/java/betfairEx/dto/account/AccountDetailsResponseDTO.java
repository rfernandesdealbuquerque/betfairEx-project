package betfairEx.dto.account;

public class AccountDetailsResponseDTO {
	private String currencyCode;
	private String firstName;
	private String lastName;
	private String localeCode;
	private String region;
	private String timezone;
	private Float discountRate;
	private Integer pointsBalance;
	private String countryCode;
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocaleCode() {
		return localeCode;
	}
	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public Float getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Float discountRate) {
		this.discountRate = discountRate;
	}
	public Integer getPointsBalance() {
		return pointsBalance;
	}
	public void setPointsBalance(Integer pointsBalance) {
		this.pointsBalance = pointsBalance;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Override
	public String toString() {
		
		return "currencyCode: " + this.getCurrencyCode() + "\n"
		+ "firstName: " + this.getFirstName() + "\n"
		+ "lastName: " + this.getLastName() + "\n"
		+ "localeCode: " + this.getLocaleCode() + "\n" 
		+ "region: " + this.getRegion() + "\n"
		+ "timeZone: " + this.getTimezone() + "\n"
		+ "discountRate: " + this.getDiscountRate() + "\n"
		+ "pointsBalance: " + this.getPointsBalance() + "\n"
		+ "countryCode: " + this.getCountryCode() + "\n";
	}
	

}
