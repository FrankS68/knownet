package de.witchcafe.knownet;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Controller;

@Controller
public class ServiceBean {
	private Service service;
	
	public String getType() {
		return "environments";
	}

	public Collection<SimpleServiceEntry> getEntries(){
		// return service.getEntries();
		service = new Service();
		service.add(new HashMap<String,Object>() {{
			put("id","42");
			put("name","test");
		}});
		service.add(new HashMap<String,Object>() {{
			put("id","43");
			put("name","qa");
		}});
		service.add(new HashMap<String,Object>() {{
			put("id","44");
			put("name","prod");
		}});
		return service.getEntries();
	}
}
