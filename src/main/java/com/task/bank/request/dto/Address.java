package com.task.bank.request.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class Address {
	
private String first_name;
private String last_name;
private String phone_no;
private String email;
private String pancard_no;
private String uid_no;
private Address address;
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getPhone_no() {
	return phone_no;
}
public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPancard_no() {
	return pancard_no;
}
public void setPancard_no(String pancard_no) {
	this.pancard_no = pancard_no;
}
public String getUid_no() {
	return uid_no;
}
public void setUid_no(String uid_no) {
	this.uid_no = uid_no;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}

 
}
