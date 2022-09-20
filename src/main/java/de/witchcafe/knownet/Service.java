package de.witchcafe.knownet;

import java.util.Collection;
import java.util.HashMap;


public class Service extends HashMap<String,ServiceEntry> {
	
	public Collection getEntries(){
		return values();
	}
	
	public void add(HashMap<String,Object> entryMap) {
		SimpleServiceEntry entry = new SimpleServiceEntry((String)entryMap.get("is"), (String)entryMap.get("name"));
		put((String)entry.getId(),entry);
	}
}