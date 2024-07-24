package com.sunbeam.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "plans")
@Entity
public class Plans {

	@Id
	
	private int uid;
	//private int plid;
	private int pactive;
	@Temporal(TemporalType.TIMESTAMP)
	private Date pstartDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date pexpDate;
	@ManyToOne
	@JoinColumn(name = "plId", referencedColumnName = "plid")
	private PlansDetails plandetails;

	public Plans() {

	}

	public Plans(int uid, int plid, int pactive, Date pstartDate, Date pexpDate, PlansDetails plandetails) {
		this.uid = uid;
	//	this.plid = plid;
		this.pactive = pactive;
		this.pstartDate = pstartDate;
		this.pexpDate = pexpDate;
		this.plandetails = plandetails;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
//
//	public int getPlid() {
//		return plid;
//	}
//
//	public void setPlid(int plid) {
//		this.plid = plid;
//	}

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

	public PlansDetails getPlandetails() {
		return plandetails;
	}

	public void setPlandetails(PlansDetails plandetails) {
		this.plandetails = plandetails;
	}

	@Override
	public String toString() {
		return "Plans [uid=" + uid + ", plid=" + /*plid */ ", pactive=" + pactive + ", pstartDate=" + pstartDate
				+ ", pexpDate=" + pexpDate + ", plandetails=" + plandetails + "]";
	}

}
