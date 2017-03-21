package com.gestionrh.www.controllers;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.gestionrh.www.report.ProductReport;

@Controller
@RequestMapping(value="product")
public class ProductController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap){
		ProductReport pr = new ProductReport();
		modelMap.put("listProducts", pr.findAll());
		return "index1";
	}
}
