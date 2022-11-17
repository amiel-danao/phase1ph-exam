package com.phase1ph.exam1;

import com.phase1ph.exam1.model.Donation;
import com.phase1ph.exam1.service.DonationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Exam1ApplicationTests {

	@Autowired
	private DonationService donationService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testDonationAddedToDb() {
		Donation donation = donationService.addNewDonation(10f, "OK");

		assertThat(donation).isNotNull();
		assertEquals(10f, donation.getAmount());
	}
}
