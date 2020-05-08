package com.tienlk25.model.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tienlk25.entity.Motorbikes;

public class ProductModelResponse {

	private Integer id;
	private String name;
	private String motorbikeType;
	private String vendor;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd@hh:mm:ss.sssz")
	private Date createOn;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd@hh:mm:ss.sssz")
	private Date modifiedOn;
	private List<VariantModelResponse> variants;
	private List<OptionModelResponse> options;
	

	public ProductModelResponse(Motorbikes motorbikes, List<VariantModelResponse> variantModels,List<OptionModelResponse> optionModels) {
		this.id = motorbikes.getId();
		this.name = motorbikes.getName();
		this.motorbikeType = motorbikes.getMotorbikeType();
		this.vendor = motorbikes.getVendor();
		this.createOn = motorbikes.getCreateOn();
		this.modifiedOn = motorbikes.getModifiedOn();
		this.variants = variantModels;
		this.options = optionModels;
	}
	
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
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public List<VariantModelResponse> getVariants() {
		return variants;
	}
	public void setVariants(List<VariantModelResponse> variants) {
		this.variants = variants;
	}
	public List<OptionModelResponse> getOptions() {
		return options;
	}

	public void setOptions(List<OptionModelResponse> options) {
		this.options = options;
	}
	
	
	
}