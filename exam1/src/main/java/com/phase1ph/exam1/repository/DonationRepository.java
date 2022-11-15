package com.phase1ph.exam1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase1ph.exam1.model.Donation;

@Repository("donationRepository")
public interface DonationRepository extends JpaRepository<Donation, Long>{

}