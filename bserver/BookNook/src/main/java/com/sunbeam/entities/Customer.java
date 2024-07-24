package com.sunbeam.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="customer")
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	private String ufirstName;
	private String ulastName;
	private String ugender;
	private String uemail;
	private String ucontactNo;
	private String upassword;
	private String urole;
	@OneToOne(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Address address;
	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "delivery",orphanRemoval = true)
//	private List<Order> orderList;
	
	public Customer() {
	}

	public Customer(int uId, String ufirstName, String ulastName, String ugender, String uemail, String ucontactNo,
			String upassword, String urole, Address address, List<Order> orderList) {
		this.uId = uId;
		this.ufirstName = ufirstName;
		this.ulastName = ulastName;
		this.ugender = ugender;
		this.uemail = uemail;
		this.ucontactNo = ucontactNo;
		this.upassword = upassword;
		this.urole = urole;
		this.address = address;
		//this.orderList = orderList;
	}

	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUfirstName() {
		return ufirstName;
	}
	public void setUfirstName(String ufirstName) {
		this.ufirstName = ufirstName;
	}
	public String getUlastName() {
		return ulastName;
	}
	public void setUlastName(String ulastName) {
		this.ulastName = ulastName;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUcontactNo() {
		return ucontactNo;
	}
	public void setUcontactNo(String ucontactNo) {
		this.ucontactNo = ucontactNo;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUrole() {
		return urole;
	}

	public void setUrole(String urole) {
		this.urole = urole;
	}
	
	

	@Override
	public String toString() {
		return "Customer [uId=" + uId + ", ufirstName=" + ufirstName + ", ulastName=" + ulastName + ", ugender="
				+ ugender + ", uemail=" + uemail + ", ucontactNo=" + ucontactNo + ", upassword=" + upassword
				+ ", urole=" + urole + ", address=" + address + "]";
	}

//	public List<Order> getOrderList() {
//		return orderList;
//	}
//
//	public void setOrderList(List<Order> orderList) {
//		this.orderList = orderList;
//	}

	
		
}
