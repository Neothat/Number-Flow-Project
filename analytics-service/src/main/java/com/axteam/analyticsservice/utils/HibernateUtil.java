package com.axteam.analyticsservice.utils;

import com.axteam.analyticsservice.entities.CounterInfo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

@Slf4j
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration()
					.addDirectory(new File("analytics-service/scr/main/resources"))
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(CounterInfo.class)
					.buildSessionFactory();
		} catch (Throwable e) {
			log.error("Initial SessionFactory creation failed. ", e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
