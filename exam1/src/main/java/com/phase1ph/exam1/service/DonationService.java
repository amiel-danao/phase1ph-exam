package com.phase1ph.exam1.service;

import java.util.List;
import java.util.Optional;

import com.phase1ph.exam1.model.Donation;

public interface DonationService {
	public List<Donation> getAllDonations();
	public Donation addNewDonation(float amount, String response);
}