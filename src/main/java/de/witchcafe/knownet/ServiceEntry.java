package de.witchcafe.knownet;

import java.util.HashMap;

public class ServiceEntry extends HashMap<String,Object>{

	private Service service;
	
	private void setService(Service s) {
		service = s;
	}
	public String getId() { return (String)get(service.idKey);}
	public String getName() { return (String)get(service.nameKey);}
}