package de.witchcafe.knownet;

import java.util.Collection;
import java.util.HashMap;

import de.witchcafe.base.StatusController;
import de.witchcafe.base.StatusController.Status;


public abstract class Service extends HashMap<String,ServiceEntry> {
	private static StatusController statusController;		
	public Service () {
		statusController.log(getClass().getCanonicalName(), Status.info, "initialised");
	}
	
	public static void setStatusController(StatusController sc) {
		statusController = sc;
	}
		
	public Collection getEntries(){
		return values();
	}
	
	public String getName() {
		return getClass().getSimpleName();
	}
	
	public String getId() {
		return getClass().getCanonicalName();
	}
	
	public String getType() {
		return getClass().getSimpleName()+".Entry";
	}
	
	public void add(HashMap<String,Object> entryMap) {
		SimpleServiceEntry entry = new SimpleServiceEntry((String)entryMap.get("id"), (String)entryMap.get("name"));
		put((String)entry.getId(),entry);
	}
}