package de.witchcafe.po;

public class PoDocument{
	private String name;
	private String type;
	Object value;
	
	public PoDocument(Station station) {
		value = station;
		type = "Station";
		name = station.getName();
	}
	
	public PoDocument(Water water) {
		value = water;
		type = "Water";
		name = water.getName();
	}
	
	public PoDocument(String name) {
		value = name;
		type = "Category";
		name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}