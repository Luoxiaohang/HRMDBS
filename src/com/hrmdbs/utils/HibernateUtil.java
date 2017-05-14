package com.hrmdbs.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {// 第二天的重构
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> threadLocale;
	static {
		Configuration config = new Configuration();
		config.configure();
		sessionFactory = config.buildSessionFactory();
		threadLocale = new ThreadLocal<Session>();
	}

	public static Session getSession() {
		Session session = threadLocale.get();
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
			threadLocale.set(session);
		}
		return session;
	}

	public static void closeSession() {
		Session session = threadLocale.get();
		if (session != null && session.isOpen()) {
			// session.close();
			// threadLocale.remove();
		}
	}
}
