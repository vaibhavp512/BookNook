package com.sunbeam.models;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sunbeam.entities.Author;
import com.sunbeam.entities.Book;

@Component
public class BookInDto {
	
	private int bId;
	private String bname;
	private Double bprice;
	private int bpages;
	private int bavCopies;
	private int btCopies;
	private MultipartFile bfront;
	private MultipartFile bback;
	private int brating;
	private Date createdTimestamp;
	private int authID;
	private String authorName;
	private int pubID;
	private String pubName;
	private int catID;
	private String catName;
	
	public BookInDto() {
		// TODO Auto-generated constructor stub
	}
	
	public BookInDto(int bId, String bname, Double bprice, int bpages, int bavCopies, int btCopies,
			MultipartFile bfront, MultipartFile bback, int brating, Date createdTimestamp, int authID,
			String authorName, int pubID, String pubName, int catID, String catName) {
		super();
		this.bId = bId;
		this.bname = bname;
		this.bprice = bprice;
		this.bpages = bpages;
		this.bavCopies = bavCopies;
		this.btCopies = btCopies;
		this.bfront = bfront;
		this.bback = bback;
		this.brating = brating;
		this.createdTimestamp = createdTimestamp;
		this.authID = authID;
		this.authorName = authorName;
		this.pubID = pubID;
		this.pubName = pubName;
		this.catID = catID;
		this.catName = catName;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Double getBprice() {
		return bprice;
	}

	public void setBprice(Double bprice) {
		this.bprice = bprice;
	}

	public int getBpages() {
		return bpages;
	}

	public void setBpages(int bpages) {
		this.bpages = bpages;
	}

	public int getBavCopies() {
		return bavCopies;
	}

	public void setBavCopies(int bavCopies) {
		this.bavCopies = bavCopies;
	}

	public int getBtCopies() {
		return btCopies;
	}

	public void setBtCopies(int btCopies) {
		this.btCopies = btCopies;
	}

	public MultipartFile getBfront() {
		return bfront;
	}

	public void setBfront(MultipartFile bfront) {
		this.bfront = bfront;
	}

	public MultipartFile getBback() {
		return bback;
	}

	public void setBback(MultipartFile bback) {
		this.bback = bback;
	}

	public int getBrating() {
		return brating;
	}

	public void setBrating(int brating) {
		this.brating = brating;
	}

	public int getAuthID() {
		return authID;
	}

	public void setAuthID(int authID) {
		this.authID = authID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public int getPubID() {
		return pubID;
	}

	public void setPubID(int pubID) {
		this.pubID = pubID;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	public int getCatID() {
		return catID;
	}

	public void setCatID(int catID) {
		this.catID = catID;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public static BookInDto fromEntity(Book entity) {
		BookInDto dto = new BookInDto();
		dto.setBname(entity.getBname());
		dto.setbId(entity.getbId());
		dto.setBprice(entity.getBprice());
		dto.setBpages(entity.getBpages());
		dto.setBavCopies(entity.getBavCopies());
		dto.setBtCopies(entity.getBtCopies());
		dto.setBrating(entity.getBrating());
		dto.setAuthID(entity.getAuthor().getaId());
		dto.setAuthorName(entity.getAuthor().getAname());
		dto.setPubID(entity.getPublisher().getPubId());
		dto.setPubName(entity.getPublisher().getPubname());
		dto.setCatID(entity.getCategory().getCatId());
		dto.setCatName(entity.getCategory().getCatname());
		return dto;
	}
	
	public static Book toEntity(BookInDto dto) {
		Book entity = new Book();
		entity.setBname(dto.getBname());
		entity.setBprice(dto.getBprice());
		entity.setBpages(dto.getBpages());
		entity.setBavCopies(dto.getBavCopies());
		entity.setBtCopies(dto.getBtCopies());
		entity.setBrating(dto.getBrating());
		return entity;
	}

	@Override
	public String toString() {
		return "BookDto [bId=" + bId + ", bname=" + bname + ", bprice=" + bprice + ", bpages=" + bpages + ", bavCopies="
				+ bavCopies + ", btCopies=" + btCopies + ", bfront=" + bfront + ", bback=" + bback + ", brating="
				+ brating + ", authID=" + authID + ", authorName=" + authorName + ", pubID=" + pubID + ", pubName="
				+ pubName + ", catID=" + catID + ", catName=" + catName + "]";
	}
		
}
