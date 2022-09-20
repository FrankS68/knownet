package de.witchcafe.knownet;

import java.util.Collection;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.witchcafe.base.StatusController;
import de.witchcafe.base.StatusController.Status;

@Controller
public class ServiceBean {
	private Service service;
	
	@Autowired
	StatusController statusController;
	
	@PostConstruct
	public void init() {
		statusController.log(getClass().getCanonicalName(), Status.info, "initialised");
		service = new Service("Environments","Environment");
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
	}
	
	public String getType() {
		return service.getType();
	}

	public Collection<SimpleServiceEntry> getEntries(){
		// return service.getEntries();
		return service.getEntries();
	}
}
