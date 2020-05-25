package com.tienlk25.model.request;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.tienlk25.CustomValidation.annotation.IsExsistName;
import com.tienlk25.CustomValidation.annotation.MotorbikeType;
import com.tienlk25.entity.Motorbikes;


public class ProductModelRequest {
	private Integer id;
	@NotNull(message = "Name of product must be not null")
	//@IsExsistName
	private String name;
	@MotorbikeType
	private String motorbikeType;
	private String vendor;
	private String tags;
	
	@Valid
	private List<VariantModelRequest> variants;
	
	public void setMotorbike(Motorbikes motorbikes,Date date) {
		if(this.name != null) {
		    motorbikes.setName(this.name);
		}if(this.motorbikeType != null) {
			motorbikes.setMotorbikeType(this.motorbikeType);
		}if(this.vendor != null) {
			motorbikes.setVendor(this.vendor);
		}if(motorbikes.getCreateOn() == null) {
			motorbikes.setCreateOn(date);
		}if(motorbikes.getModifiedOn() != date) {
			motorbikes.setModifiedOn(date);
		}if(this.vendor != null) {
			motorbikes.setTags(this.tags);
		}
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
	public List<VariantModelRequest> getVariants() {
		return variants;
	}
	public void setVariants(List<VariantModelRequest> variants) {
		this.variants = variants;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
}
