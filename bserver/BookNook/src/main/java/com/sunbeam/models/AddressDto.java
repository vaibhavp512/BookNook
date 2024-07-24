package com.sunbeam.models;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Address;
import com.sunbeam.entities.Book;

@Component
public class AddressDto {
	
	private int aid;
	private String uaddr;
	private String ucity;
	private String ustate;
	private int upinCode;
	private int uid;
	
	public AddressDto() {
		// TODO Auto-generated constructor stub
	}

	public AddressDto(int aid, String uaddr, String ucity, String ustate, int upinCode, int uid) {
		this.aid = aid;
		this.uaddr = uaddr;
		this.ucity = ucity;
		this.ustate = ustate;
		this.upinCode = upinCode;
		this.uid = uid;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public static AddressDto fromEntity(Address entity) {
		AddressDto dto = new AddressDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setUid(entity.getCustomer().getuId());
		return dto;
	}
	
	public static Address toEntity(AddressDto dto) {
		Address entity = new Address();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public String toString() {
		return "AddressDto [aid=" + aid + ", uaddr=" + uaddr + ", ucity=" + ucity + ", ustate=" + ustate + ", upinCode="
				+ upinCode + ", uid=" + uid + "]";
	}
	
	

}
