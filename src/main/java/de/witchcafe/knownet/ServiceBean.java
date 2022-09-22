package de.witchcafe.knownet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.witchcafe.base.StatusController;
import de.witchcafe.base.StatusController.Status;
import de.witchcafe.knownet.services.HardCodedService;
import de.witchcafe.knownet.services.PegelOnlineService;

@Controller
public class ServiceBean {
	private Service service;
	private ArrayList<Service> services = new ArrayList<Service>();
	private HashMap<String,Service> servicesById = new HashMap<String,Service>();
	
	@Autowired
	StatusController statusController;
	
	@PostConstruct
	public void init() {
		Service.setStatusController(statusController);
		statusController.log(getClass().getCanonicalName(), Status.info, "initialised");
		addService(new HardCodedService());
		addService(new PegelOnlineService());
	}
	
	public void addService(Service service) {
		services.add(service);
		servicesById.put(service.getId(),service);
	}
	

	public String getPageTitle() {
		return "Service Maintenance";
	}
	
	public Service getService(String id){
		return servicesById.get(id);
	}

	public Collection<Service> getServices(){
		return services;
	}


}
