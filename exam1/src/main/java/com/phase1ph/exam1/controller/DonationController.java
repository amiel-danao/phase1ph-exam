package com.phase1ph.exam1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DonationController {
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String goHome(){
		return "index";
	}
}
