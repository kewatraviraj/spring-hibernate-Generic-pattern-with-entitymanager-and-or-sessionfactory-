/**
 * 
 */
package com.testspringhibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dell
 *
 */
@Controller
@RequestMapping("/test")
public class ControllerTest {
	
	/*@Autowired
	Datadetails displaydata;
	@Autowired
	DatadetailsService datadetailservice;*/
	
/*	@RequestMapping("/testdelete")
	public String say(@ModelAttribute Datadetails displaydata, ModelMap model) {
		model.addAttribute("greeting", displaydata +"to Hello World from Spring MVC");
		if(datadetailservice.delete(displaydata.getId()))
			model.addAttribute("deleteddata", "Data of Id :"+displaydata+" was deleted from Db");		
		return "welcome";
	}*/
}
