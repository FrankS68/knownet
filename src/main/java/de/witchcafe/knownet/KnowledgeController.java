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

	    System.out.println(System.getProperties());
	    return mav;
	}

	@RequestMapping("/service/*")
	public ModelAndView getService() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("serviceTable");

	    System.out.println(System.getProperties());
	    return mav;
	}

}
