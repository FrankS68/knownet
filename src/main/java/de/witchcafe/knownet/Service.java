package de.witchcafe.knownet;

import java.util.Collection;
import java.util.HashMap;


public class Service extends HashMap<String,ServiceEntry> {
	String idKey;
	String nameKey;
	
	public Collection getEntries(){
		return values();
	}
	
	public void add(HashMap<String,Object> entryMap) {
		ServiceEntry entry = (ServiceEntry)entryMap;
		put((String)entry.getId(),entry);
	}
}