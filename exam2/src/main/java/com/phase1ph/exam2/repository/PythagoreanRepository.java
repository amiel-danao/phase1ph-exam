package com.phase1ph.exam2.repository;

import com.phase1ph.exam2.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("pythagoreanRepository")
public interface PythagoreanRepository extends JpaRepository<Response, Long> {

}