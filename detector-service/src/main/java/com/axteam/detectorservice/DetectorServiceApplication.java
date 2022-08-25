package com.axteam.detectorservice;

import com.axteam.detectorservice.services.DetectorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;

@SpringBootApplication
public class DetectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetectorServiceApplication.class, args);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new DetectorService(), 0, 60 * 1000);
	}
}
