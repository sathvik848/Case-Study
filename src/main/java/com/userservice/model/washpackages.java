package com.userservice.model;

import org.springframework.data.annotation.Id;

public class washpackages {

	@Id
	private Long id;
	private String packagename;
	private float cost;
	private String description;
	

	
	public washpackages() {
		super();
	}
	public washpackages(Long id, String packagename, float cost, String description) {
		super();
		this.id = id;
		this.packagename = packagename;
		this.cost = cost;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPackagename() {
		return packagename;
	}
	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "washpackages [id=" + id + ", packagename=" + packagename + ", cost=" + cost + ", description="
				+ description + "]";
	}
	
	
	
	
}
