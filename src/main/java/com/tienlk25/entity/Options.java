package com.tienlk25.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "options")
public class Options {
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "position")
	private Integer position;

	@Column(name = "variant_id")
	private Integer variantId;

	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "value")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public Options(Integer id) {
		super();
		this.id = id;
	}

	public Options() {
//      Date date, Integer id
//		this.name = "color";
//		this.position = 1;
//		this.variantId = id;
//		this.status = true;
//		this.createOn = date;
//		this.modifiedOn = date;
	}

	public Options(String name) {
		this.name = name;
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

	public void setVariantId(Integer variantId) {
		this.variantId = variantId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVariantId() {
		return variantId;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


}
