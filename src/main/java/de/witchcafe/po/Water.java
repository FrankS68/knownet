package de.witchcafe.po;

import org.springframework.util.StringUtils;

public class Water{
	private String name;

	private String id;
	public String getName() {
		return StringUtils.capitalize(name.toLowerCase());
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Water(String n,String i) {
		name = n;
		id = i;
	}
}