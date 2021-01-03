package de.witchcafe.po;

import java.util.Map;

import org.springframework.util.StringUtils;

public class Station{

	private String name;
	private String id;
	private Double km;
	private Double longitude;
	private Double latitude;
	private Water river;

	public Station(Map values) {
		this((String)values.get("name"),(String)values.get("id"));
	}

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

	public Station(String n, String i) {
		name = n;
		id = i;
	}

	public Double getKm() {
		return km;
	}

	public void setKm(Double km) {
		this.km = km;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Water getRiver() {
		return river;
	}

	public void setRiver(Water river) {
		this.river = river;
	}
}