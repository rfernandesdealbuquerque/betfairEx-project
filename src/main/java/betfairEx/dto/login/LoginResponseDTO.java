package betfairEx.dto.login;

public class LoginResponseDTO {
	
	private String token;
	private String product;
	private String status;
	private String error;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		
		return "token: " + this.getToken() + "\n"
		+ "product: " + this.getProduct() + "\n"
		+ "status: " + this.getStatus() + "\n"
		+ "error: " + this.getError() + "\n"; 
		
	}

}
