package com.tienlk25.model.response;



import java.util.ArrayList;
import java.util.List;

import com.tienlk25.entity.Options;

public class OptionModelResponse {

	private Integer id;
	
	private Integer product_id;
	private String name;
	private Integer position;
	List<String> values = new ArrayList<String>();
	
	public OptionModelResponse(Options options,Integer id) {
		this.product_id = id;
		this.name = options.getName();
		this.position = options.getPosition();
	}
	
	
	public void addValue(String value) {
		if(value == null) {
			return;
		}
		this.values.add(value);
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
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public List<String> getValues() {
		return values;
	}


	public void setValues(List<String> values) {
		this.values = values;
	}


	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	
	
	
}
