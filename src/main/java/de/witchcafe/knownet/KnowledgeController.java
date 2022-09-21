package de.witchcafe.knownet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.witchcafe.base.StatusController;
import de.witchcafe.base.StatusController.Status;

@Controller
public class KnowledgeController {
	@Autowired
	StatusController statusController;
	
	@PostConstruct
	public void init() {
		statusController.log(getClass().getCanonicalName(), Status.info, "initialised");
	}

	@RequestMapping("/")
	public ModelAndView getRoot() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("index");

	    return mav;
	}

	@RequestMapping("/status")
	public ModelAndView getStatus() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("status");

	    return mav;
	}

	@RequestMapping("/service/*")
	public ModelAndView getService() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("serviceTable");

	    return mav;
	}

	@RequestMapping("/services")
	public ModelAndView getServices() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("services");

	    return mav;
	}

}
