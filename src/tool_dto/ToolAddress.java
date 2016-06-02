package tool_dto;

import java.io.Serializable;

public class ToolAddress implements Serializable
{
String village;
String houseNo;
String tehsil;
String district;
String state;
int pincode;
public ToolAddress(String village, String houseNo, String tehsil, String district,
		String state, int pincode) {
	super();
	this.village = village;
	this.houseNo = houseNo;
	this.tehsil = tehsil;
	this.district = district;
	this.state = state;
	this.pincode = pincode;
}

public String getVillage() {
	return village;
}

public void setVillage(String village) {
	this.village = village;
}

public String getHouseNo() {
	return houseNo;
}

public void setHouseNo(String houseNo) {
	this.houseNo = houseNo;
}

public String getTehsil() {
	return tehsil;
}

public void setTehsil(String tehsil) {
	this.tehsil = tehsil;
}

public String getDistrict() {
	return district;
}

public void setDistrict(String district) {
	this.district = district;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public int getPincode() {
	return pincode;
}

public void setPincode(int pincode) {
	this.pincode = pincode;
}

@Override
public String toString() {
	return "Address [village=" + village + ", houseNo=" + houseNo + ", tehsil="
			+ tehsil + ", district=" + district + ", state=" + state
			+ ", pincode=" + pincode + "]";
}




}
