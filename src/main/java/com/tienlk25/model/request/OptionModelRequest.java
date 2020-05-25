package com.tienlk25.model.request;



import org.springframework.validation.annotation.Validated;

import com.tienlk25.entity.Options;

@Validated
public class OptionModelRequest {

	final String NAME_VALUE_DEFAULFT = "Title";
	private Integer id;
	private String name;
	private String value;

	public void setDefaultOption(Options options) {
		options.setName(NAME_VALUE_DEFAULFT);
		options.setPosition(1);
		options.setStatus(true);
	}

	public void setOption(Options options) {
		//if (this.name != null) {
			options.setName(this.name);
		//}
		options.setStatus(true);
		
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
