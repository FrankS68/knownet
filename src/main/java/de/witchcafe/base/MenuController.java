package de.witchcafe.base;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.witchcafe.base.StatusController.Status;

@Controller
public class MenuController{
	@Autowired
	StatusController statusController;

	public String getPageTitle() {
		return "Status Overview";
	}

	
	@PostConstruct
	public void init() {
		statusController.log(getClass().getCanonicalName(), Status.info, "initialised");
	}
}
