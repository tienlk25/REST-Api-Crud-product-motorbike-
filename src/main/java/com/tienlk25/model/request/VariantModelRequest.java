package com.tienlk25.model.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


import com.tienlk25.entity.Variants;

public class VariantModelRequest {

	private Integer id;
	private String title;
	@Min(value = 30000000)
	private BigDecimal price;
	private Integer position;
	private Integer weight;
	private String weightUnit;
	@Min(value = 125)
	private Integer cc;
	private String warranty;
	@Size(min = 0,max = 3,message = "List Option must be between 0 and 3 characters")
	@Valid
	private List<OptionModelRequest> options;
	
	public void setDefaultVariant(Variants variants, Date date ,Integer id) {
		variants.setTitle("Sự lựa chọn hoàn hảo");
		variants.setPrice(new BigDecimal("30000000"));
        variants.setStatus(true);
		variants.setPosition(1);
		variants.setWeight(120);
		variants.setWeightUnit("kg");
		variants.setCreateOn(date);
		variants.setModifiedOn(date);
		variants.setCc(125);
        variants.setWarranty("3 năm / 30000 km (tuỳ điều kiện nào đến trước)");
		variants.setMotorbikeId(id);
	}
	
	public void setVarriant(Variants variants, Date date, Integer id) {
		if(this.id != null) {
			variants.setId(this.id);
		}if(this.id == null) {
			variants.setCreateOn(date);
		}if(this.title != null) {
			 variants.setTitle(this.title);
		}if(this.price != null) {
			 variants.setPrice(this.price);
		}if(this.weight != null) {
			variants.setWeight(this.weight);
		}if(this.weightUnit != null) {
			 variants.setWeightUnit(this.weightUnit);
		}if(this.cc != null) {
			 variants.setCc(this.cc);
		}if(this.warranty != null) {
			variants.setWarranty(this.warranty);
		}if(variants.getModifiedOn() != date) {
			variants.setModifiedOn(date);
		}if(id != null) {
			variants.setMotorbikeId(id);
		}
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
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public Integer getCc() {
		return cc;
	}
	public List<OptionModelRequest> getOptions() {
		return options;
	}

	public void setOptions(List<OptionModelRequest> options) {
		this.options = options;
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

	
}
