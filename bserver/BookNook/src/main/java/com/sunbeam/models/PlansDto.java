package com.sunbeam.models;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Plans;

@Component
public class PlansDto {

	private int uid;
	private int plid;
	private int pactive;
	private Date pstartDate;
	private Date pexpDate;
	private String pname;
	private double pamount;
	private int pblimit;
	//private int pdID;

	public PlansDto() {

	}

	public PlansDto(int uid, int plid, int pactive, Date pstartDate, Date pexpDate, int pdID) {
		this.uid = uid;
		this.plid = plid;
		this.pactive = pactive;
		this.pstartDate = pstartDate;
		this.pexpDate = pexpDate;
		//this.pdID = pdID;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPlid() {
		return plid;
	}

	public void setPlid(int plid) {
		this.plid = plid;
	}

	public int getPactive() {
		return pactive;
	}

	public void setPactive(int pactive) {
		this.pactive = pactive;
	}

	public Date getPstartDate() {
		return pstartDate;
	}

	public void setPstartDate(Date pstartDate) {
		this.pstartDate = pstartDate;
	}

	public Date getPexpDate() {
		return pexpDate;
	}

	public void setPexpDate(Date pexpDate) {
		this.pexpDate = pexpDate;
	}

//	public int getPdID() {
//		return pdID;
//	}
//
//	public void setPdID(int pdID) {
//		this.pdID = pdID;
//	}

	@Override
	public String toString() {
		return "PlansDto [uid=" + uid + ", plid=" + plid + ", pactive=" + pactive + ", pstartDate=" + pstartDate
				+ ", pexpDate=" + pexpDate + ", pdID=" /*+ pdID + */ ;
	}

	public static PlansDto fromEntity(Plans entity) {
		PlansDto dto = new PlansDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setPlid(entity.getPlandetails().getPlid());
		dto.setPname(entity.getPlandetails().getPname());
		dto.setPamount(entity.getPlandetails().getPamount());
		dto.setPblimit(entity.getPlandetails().getPblimit());
		return dto;

	}

	public static Plans toEntity(PlansDto dto) {
		Plans entity = new Plans();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
