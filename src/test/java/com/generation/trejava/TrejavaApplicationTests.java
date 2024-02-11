package com.generation.trejava;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.trejava.model.entities.Passenger;
import com.generation.trejava.model.repositories.PassengerRepository;

@SpringBootTest
class TrejavaApplicationTests {

	@Autowired
	PassengerRepository repo;
	
	@Test
	void contextLoads() {
		Passenger p = Passenger.builder()
						.name("Luca")
						.surname("Giurato")
						.age(30)
						.build();
		p =repo.save(p);
	}

}
