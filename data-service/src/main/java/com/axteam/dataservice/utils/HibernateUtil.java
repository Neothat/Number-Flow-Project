package com.axteam.dataservice.utils;

import com.axteam.dataservice.entities.DataRecord;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

@Slf4j
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration()
					.addDirectory(new File("data-service/scr/main/resources"))
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(DataRecord.class)
					.buildSessionFactory();
		} catch (Throwable e) {
			log.error("Initial SessionFactory creation failed. ", e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
