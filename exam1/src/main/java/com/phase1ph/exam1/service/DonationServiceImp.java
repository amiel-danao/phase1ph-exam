package com.phase1ph.exam1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase1ph.exam1.model.Donation;
import com.phase1ph.exam1.repository.DonationRepository;


@Service("donationService")
public class DonationServiceImp implements DonationService {

	@Autowired
	private DonationRepository donationRepository;
	
	@Override
	public List<Donation> getAllDonations() {
		return donationRepository.findAll();
	}

	@Override
	public Donation addNewDonation(float amount, String response) {
		Donation donation = new Donation(amount, response);
		
		return donationRepository.save(donation);
	}

}
