package com.tienlk25.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "motorbikes")
public class Motorbikes {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="name")
	private String name;

	@Column(name = "motobike_type")
	private String motorbikeType;
	
	@Column(name = "vendor")
	private String vendor;
 	
	@Column(name = "create_on")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd@hh:mm:ss.sssz")
	private Date createOn;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMotorbikeType() {
		return motorbikeType;
	}

	public void setMotorbikeType(String motorbikeType) {
		this.motorbikeType = motorbikeType;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "modified_on")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd@hh:mm:ss.sssz")
	private Date modifiedOn;
	
	
	

}
