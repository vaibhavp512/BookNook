package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "planDetails")
@Entity
public class PlansDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int plid;
	private String pname;
	private double pamount;
	private int pblimit;

	@OneToMany(mappedBy = "plandetails")
	private List<Plans> planList;

	public PlansDetails() {

	}

	public PlansDetails(int plid, String pname, double pamount, int pblimit, List<Plans> planList) {
		this.plid = plid;
		this.pname = pname;
		this.pamount = pamount;
		this.pblimit = pblimit;
		this.planList = planList;
	}

	public int getPlid() {
		return plid;
	}

	public void setPlid(int plid) {
		this.plid = plid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPamount() {
		return pamount;
	}

	public void setPamount(double pamount) {
		this.pamount = pamount;
	}

	public int getPblimit() {
		return pblimit;
	}

	public void setPblimit(int pblimit) {
		this.pblimit = pblimit;
	}

	public List<Plans> getPlanList() {
		return planList;
	}

	public void setPlanList(List<Plans> planList) {
		this.planList = planList;
	}

	@Override
	public String toString() {
		return "PlansDetails [plid=" + plid + ", pname=" + pname + ", pamount=" + pamount + ", pblimit=" + pblimit
				+ ", planList=" + planList + "]";
	}

}
