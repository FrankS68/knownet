package de.witchcafe.knownet;

public class SimpleServiceEntry implements ServiceEntry {
// extends HashMap<String,Object>{

	private String id;
	private String name;
	
	public SimpleServiceEntry(String i,String n) {
		id = i;
		name = n;
	}
	
	public String getId() { return id;}
	public String getName() { return name;}
}