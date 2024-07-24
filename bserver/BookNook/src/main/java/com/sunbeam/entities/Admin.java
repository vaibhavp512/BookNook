package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="admin")
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adId;
	private String adname;
	private String ademail;
	private String adpassword;
	
	public Admin() {
	}

	public Admin(int adId, String adname, String ademail, String adpassword) {
		this.adId = adId;
		this.adname = adname;
		this.ademail = ademail;
		this.adpassword = adpassword;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public String getadname() {
		return adname;
	}

	public void setadname(String adname) {
		this.adname = adname;
	}

	public String getAdemail() {
		return ademail;
	}

	public void setAdemail(String ademail) {
		this.ademail = ademail;
	}

	public String getAdpassword() {
		return adpassword;
	}

	public void setAdpassword(String adpassword) {
		this.adpassword = adpassword;
	}

	@Override
	public String toString() {
		return "Admin [adId=" + adId + ", adname=" + adname + ", ademail=" + ademail + ", adpassword=" + adpassword
				+ "]";
	}

	
}
