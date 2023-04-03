package betfairEx.model;

import java.util.Date;

public class Event {
	private int id;
	private String name;
	private Date openDate;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setId(int id) {
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
		return id + " " + name + " ";
	}
	
	@Override
	public boolean equals(Object event) {
		if(this.id == ((Event) event).getId()) {
			return true;
			
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.id;
		
	}
	

}
