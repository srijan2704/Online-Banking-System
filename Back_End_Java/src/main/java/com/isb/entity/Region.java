package com.isb.entity;
import javax.persistence.*;

@Entity
@Table(name="TB1_REGION")
public class Region  {

	@Id
	@Column(name="REGION_ID")
	private long regionId;
	@Column
	private String city;
	@Column
	private String pincode;
	@Column
	private String state;
	public long getRegionId() {
		return regionId;
	}
	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Regions [regionId=" + regionId + ", city=" + city + ", pincode=" + pincode + ", state=" + state + "]";
	}

	
}