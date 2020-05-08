package com.tienlk25.model.request;


import org.springframework.validation.annotation.Validated;

import com.tienlk25.entity.Options;

@Validated
public class OptionModelRequest {

	private Integer id;
	private String name;
	private String value;

	public void setDefaultOption(Options options, Integer id) {
		options.setName("Title");
		options.setValue("Default Title");
		options.setPosition(1);
		options.setVariantId(id);
		options.setStatus(true);
	}

	public void setOption(Options options, Integer id) {
		if (this.name != null) {
			options.setName(this.name);
		}
		if(this.value != null) {
			options.setValue(this.value);
		}
		if(options.getId() == null) {
			options.setVariantId(id);
		}if(options.getStatus() == null) {
			options.setStatus(true);
		}
		
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
