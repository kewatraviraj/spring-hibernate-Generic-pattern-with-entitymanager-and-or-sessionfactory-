/**
 * 
 */
package com.testspringhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testspringhibernate.model.Datadetails;
import com.testspringhibernate.service.DatadetailsService;

/**
 * @author Dell
 *
 */
@Controller
@RequestMapping("/a")
public class TestController {
	
	@Autowired
	DatadetailsService datadetailservice;
	
	 @RequestMapping(value = "/test", method = RequestMethod.GET)
	    public String sayHello(ModelMap model,@ModelAttribute Datadetails displaydata) {
		 //	model.addAttribute("greeting", displaydata +"to Hello World from Spring MVC");
		 	model.addAttribute("detaillist", datadetailservice.listDeatails());
		 //	 	model.addAttribute("time","Jan 08 2015 20:40:56 GMT+0530 (IST)");
	        return "welcome";
	    }
}
