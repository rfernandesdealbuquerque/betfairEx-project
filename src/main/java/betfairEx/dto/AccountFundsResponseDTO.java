package betfairEx.dto;

public class AccountFundsResponseDTO {
	private String jsonrpc;
	private AccountFundsResult result;
	private int id;
	
	public String getJsonrpc() {
		return jsonrpc;
	}

	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}
	public AccountFundsResult getResult() {
		return result;
	}

	public void setResult(AccountFundsResult result) {
		this.result = result;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}




	private class AccountFundsResult{
		private float availableToBetBalance;
        private float exposure;
        private float retainedCommission;
        private float exposureLimit;
        private float discountRate;
        private int pointsBalance;
        private String wallet;
        
		public float getAvailableToBetBalance() {
			return availableToBetBalance;
		}
		public float getExposure() {
			return exposure;
		}
		public float getRetainedCommission() {
			return retainedCommission;
		}
		public float getExposureLimit() {
			return exposureLimit;
		}
		public float getDiscountRate() {
			return discountRate;
		}
		public int getPointsBalance() {
			return pointsBalance;
		}
		public String getWallet() {
			return wallet;
		}
	}
	
	@Override
	public String toString() {
		AccountFundsResult result = this.getResult();
		return "availableToBetBalance: " + result.getAvailableToBetBalance()+ "\n"
		+ "exposure: " + result.getExposure() + "\n"
		+ "retainedCommision: " + result.getRetainedCommission() + "\n"
		+ "exposureLimit: " + result.getExposureLimit() + "\n"
		+ "discountRate: " + result.getDiscountRate() + "\n"
		+ "pointsBalance: " + result.getPointsBalance() + "\n"
		+ "wallet: " + result.getWallet() + "\n";
	}

}
