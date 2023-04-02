package betfairEx.model;

import java.util.Date;

public class Event {
	private Integer id;
	private String name;
	private Date openDate;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	
	@Override
	public String toString() {
		return id + name + openDate.toString();
	}
	

}
