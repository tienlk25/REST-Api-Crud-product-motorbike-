package com.tienlk25.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "variant")
public class Variants {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "position")
	private Integer position;
	
	@Column(name = "weight")
	private Integer weight;
	
	
	@Column(name = "weight_unit")
	private String weightUnit;
	
	@Column(name = "create_on")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd@hh:mm:ss.sssz")
	private Date createOn;

	@Column(name = "cc")
	private Integer cc;
	
	@Column(name = "warranty")
	private String warranty;
	
	@Column(name = "modified_on")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd@hh:mm:ss.sssz")
	private Date modifiedOn;
	
 	@Column(name = "motorbike_id")
 	private Integer motorbikeId;
	
	


	public Variants() {
	
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWeightUnit() {
		return weightUnit;
	}


	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}


	public Date getCreateOn() {
		return createOn;
	}


	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}


	public Date getModifiedOn() {
		return modifiedOn;
	}


	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Integer getMotorbikeId() {
		return motorbikeId;
	}

	public void setMotorbikeId(Integer motorbikeId) {
		this.motorbikeId = motorbikeId;
	}

	public Integer getCc() {
		return cc;
	}

	public void setCc(Integer cc) {
		this.cc = cc;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Integer getPosition() {
		return position;
	}

	public Integer getWeight() {
		return weight;
	}
}
