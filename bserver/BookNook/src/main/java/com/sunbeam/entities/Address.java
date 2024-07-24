package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="address")
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String uaddr;
	private String ucity;
	private String ustate;
	private int upinCode;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cusId", nullable = false)
    private Customer customer;
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int aid, String uaddr, String ucity, String ustate, int upinCode, Customer customer) {
		this.aid = aid;
		this.uaddr = uaddr;
		this.ucity = ucity;
		this.ustate = ustate;
		this.upinCode = upinCode;
		this.customer = customer;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getUaddr() {
		return uaddr;
	}

	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}

	public String getUcity() {
		return ucity;
	}

	public void setUcity(String ucity) {
		this.ucity = ucity;
	}

	public String getUstate() {
		return ustate;
	}

	public void setUstate(String ustate) {
		this.ustate = ustate;
	}

	public int getUpinCode() {
		return upinCode;
	}

	public void setUpinCode(int upinCode) {
		this.upinCode = upinCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", uaddr=" + uaddr + ", ucity=" + ucity + ", ustate=" + ustate + ", upinCode="
				+ upinCode;
	}
	
}
