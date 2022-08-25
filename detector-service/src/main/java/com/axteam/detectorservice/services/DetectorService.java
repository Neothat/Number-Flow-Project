package com.axteam.detectorservice.services;

import org.springframework.stereotype.Service;

import java.util.TimerTask;

@Service
public class DetectorService extends TimerTask {

	public static byte generateNumber() {
		return (byte) (Math.random() * 100);
	}

	@Override
	public void run() {
		byte number = generateNumber();
		// Отправка в Kafka
	}
}
