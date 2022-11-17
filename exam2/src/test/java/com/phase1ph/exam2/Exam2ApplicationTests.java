package com.phase1ph.exam2;

import com.phase1ph.exam2.model.Pythagorean;
import com.phase1ph.exam2.model.Response;
import com.phase1ph.exam2.service.PythagoreanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Exam2ApplicationTests {

	@Autowired
	private PythagoreanService pythagoreanService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testComputePythagorean() {

		Pythagorean result = pythagoreanService.computePythagorean(5);

		assertEquals(result.getA(), 3);
		assertEquals(result.getB(), 4);
		assertEquals(result.getAverage(), 4);
	}

	@Test
	public void testResponseAddedToDb() {
		Response testResponse = new Response();

		Response response = pythagoreanService.addResponseToDb(testResponse);

		assertThat(response).isNotNull();
	}

}
