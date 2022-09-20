package de.witchcafe.knownet;

import java.util.Collection;
import java.util.HashMap;


public class Service extends HashMap<String,ServiceEntry> {
	
	private String name;
	private String type;
	
	public Service (String name,String type) {
		this.name = name;
		this.type = type;
	}
	
	public Collection getEntries(){
		return values();
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public void add(HashMap<String,Object> entryMap) {
		SimpleServiceEntry entry = new SimpleServiceEntry((String)entryMap.get("id"), (String)entryMap.get("name"));
		put((String)entry.getId(),entry);
	}
}