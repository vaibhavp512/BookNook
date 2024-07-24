package com.sunbeam.models;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Address;
import com.sunbeam.entities.Customer;

@Component
public class CustomerDto {
	private int uId;
	private String ufirstName;
	private String ulastName;
	private String ugender;
	private String uemail;
	private String ucontactNo;
	private String upassword;
	private String uaddr;
	private String ucity;
	private String ustate;
	private int upinCode;
	private String urole;
	
	public CustomerDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDto(int uId, String ufirstName, String ulastName, String ugender, String uemail, String ucontactNo,
			String upassword, String uaddr, String ucity, String ustate, int upinCode, String urole) {
		this.uId = uId;
		this.ufirstName = ufirstName;
		this.ulastName = ulastName;
		this.ugender = ugender;
		this.uemail = uemail;
		this.ucontactNo = ucontactNo;
		this.upassword = upassword;
		this.uaddr = uaddr;
		this.ucity = ucity;
		this.ustate = ustate;
		this.upinCode = upinCode;
		this.urole = urole;
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
	
	public String getUrole() {
		return urole;
	}

	public void setUrole(String urole) {
		this.urole = urole;
	}

	public static CustomerDto fromEntity(Customer entity) {
		CustomerDto dto = new CustomerDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getAddress()==null) {
			return dto;
		}
		dto.setUaddr(entity.getAddress().getUaddr());
		dto.setUcity(entity.getAddress().getUcity());
		dto.setUstate(entity.getAddress().getUstate());
		dto.setUpinCode(entity.getAddress().getUpinCode());
		return dto;
	}
	
	public static Customer toEntity(CustomerDto dto) {
		Customer entity = new Customer();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
		

	@Override
	public String toString() {
		return "CustomerDto [uId=" + uId + ", ufirstName=" + ufirstName + ", ulastName=" + ulastName + ", ugender="
				+ ugender + ", uemail=" + uemail + ", ucontactNo=" + ucontactNo + ", upassword=" + upassword
				+ ", uaddr=" + uaddr + ", ucity=" + ucity + ", ustate=" + ustate + ", upinCode=" + upinCode + "]";
	}
	
	
}
