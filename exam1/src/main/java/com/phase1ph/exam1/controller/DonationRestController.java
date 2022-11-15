package com.phase1ph.exam1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import com.phase1ph.exam1.model.Donation;
import com.phase1ph.exam1.model.Response;
import com.phase1ph.exam1.service.DonationService;


@RestController
public class DonationRestController {	
	
	@Autowired
	private DonationService donationService;
	
	@RequestMapping(path = "/donations", method = RequestMethod.GET)
	public List<Donation> getAllDonations(){
		return donationService.getAllDonations();
	}

    
    @PostMapping("/donate")
    public String donate(@RequestParam("amount") String amount) {
    	String result = "";
    	float donationAmount = 0;
    	
    	try {
    		donationAmount = Float.parseFloat(amount);
    	}
    	catch(NumberFormatException exception) {
    		result = exception.getMessage();
    		donationService.addNewDonation(0, result);
    	}
    	
    	try {
    		result = String.format(Response.DONATE_SUCCESS_MESSAGE, amount);
    		donationService.addNewDonation(donationAmount, Response.STATUS_OK);
    	}    	
    	catch(Exception exception){
    		result = exception.getMessage();
    		donationService.addNewDonation(donationAmount, result);
    	}
    	 
    	return result;
    }

}