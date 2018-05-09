
package com.niit.BSonlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/supplier")

public class SupplierController {
	
	
		@RequestMapping(value = "/details", method = RequestMethod.GET)
		public ModelAndView showSupplierDetails() {

			ModelAndView mv = new ModelAndView("page");

			mv.addObject("userClickSupplierDetails", true);
			mv.addObject("title", "Supplier Details");

			return mv;
		}

}
