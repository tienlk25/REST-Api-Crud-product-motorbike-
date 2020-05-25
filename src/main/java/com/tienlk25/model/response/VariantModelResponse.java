package com.tienlk25.model.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tienlk25.entity.Options;
import com.tienlk25.entity.Variants;
import com.tienlk25.model.request.OptionModelRequest;

public class VariantModelResponse {
	private Integer id;
	private String title;
	private BigDecimal price;
	private Integer position;
	private Integer cc;
	private String warranty;
	private String option1;
	private String option2;
	private String option3;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd@hh:mm:ss.sssz")
	private Date createOn;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd@hh:mm:ss.sssz")
	private Date modifiedOn;
	private Integer weight;
	private String weightUnit;
	
	
	
	public VariantModelResponse(Variants variants, String[] options) {
		this.id = variants.getId();
		this.title = variants.getTitle();
		this.price = variants.getPrice();
		this.position = variants.getPosition();
		this.weight = variants.getWeight();
		this.weightUnit = variants.getWeightUnit();
		this.createOn = variants.getCreateOn();
		this.modifiedOn = variants.getModifiedOn();
		this.cc = variants.getCc();
		this.warranty = variants.getWarranty();
		this.option1 = options[0];
		this.option2 = options[1];
		this.option3 = options[2];
		
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
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
	
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
}
