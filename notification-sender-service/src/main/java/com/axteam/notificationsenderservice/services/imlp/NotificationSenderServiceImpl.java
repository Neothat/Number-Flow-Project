package com.axteam.notificationsenderservice.services.imlp;

import com.axteam.notificationsenderservice.services.NotificationSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationSenderServiceImpl implements NotificationSenderService {

	private JavaMailSender javaMailSender;
	@Value("${spring.mail.sender.email}")
	private String senderEmail;
	@Value("${spring.mail.sender.text}")
	private String senderText;
	@Value("${spring.mail.username}")
	private String receiver;

	@Override
	public void sendSimpleEmail(byte number) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(senderEmail);
		mailMessage.setTo(receiver);
		mailMessage.setSubject("mayday mayday mayday");
		mailMessage.setText("The indicator came to us - " + number);
		getJavaMailSender().send(mailMessage);
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
}
