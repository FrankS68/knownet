package de.witchcafe.knownet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KnowledgeController {
	
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

}
