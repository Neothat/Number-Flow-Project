package com.axteam.dataservice.utils;

import com.axteam.dataservice.DataServiceApplication;
import com.axteam.dataservice.models.DataRecord;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class HibernateUtil {
	private static final Logger logger = LoggerFactory.getLogger(DataServiceApplication.class);
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration()
					.addDirectory(new File("data-service/scr/main/resources"))
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(DataRecord.class)
					.buildSessionFactory();
		} catch (Throwable e) {
			logger.error("Initial SessionFactory creation failed. ", e);
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
