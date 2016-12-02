package org.javabrains.koushik.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride	(name="street", column=@Column (name="HOME_STREET_NAME")),
	@AttributeOverride	(name="city", column=@Column (name="HOME_CITY_NAME")),
	@AttributeOverride	(name="state", column=@Column (name="HOME_STATE_NAME")),
	@AttributeOverride	(name="pincode", column=@Column (name="HOME_PIN_CODE"))})
	private Address Homeaddress;
	@Embedded
	private Address Officeaddress;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Address getHomeaddress() {
		return Homeaddress;
	}
	public void setHomeaddress(Address homeaddress) {
		Homeaddress = homeaddress;
	}
	public Address getOfficeaddress() {
		return Officeaddress;
	}
	public void setOfficeaddress(Address officeaddress) {
		Officeaddress = officeaddress;
	}
	
}
