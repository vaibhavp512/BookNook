package com.sunbeam.models;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Plans;
import com.sunbeam.entities.PlansDetails;

@Component
public class PlanDetailsDto {
	private int plid;
	private String pname;
	private double pamount;
	private int pblimit;
	
	public PlanDetailsDto() {
		// TODO Auto-generated constructor stub
	}

	public PlanDetailsDto(int plid, String pname, double pamount, int pblimit) {
		super();
		this.plid = plid;
		this.pname = pname;
		this.pamount = pamount;
		this.pblimit = pblimit;
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
	
	public static PlanDetailsDto fromEntity(PlansDetails entity) {
		PlanDetailsDto dto = new PlanDetailsDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;

	}

	@Override
	public String toString() {
		return "PlanDetailsDto [plid=" + plid + ", pname=" + pname + ", pamount=" + pamount + ", pblimit=" + pblimit
				+ "]";
	}
	
	
}
