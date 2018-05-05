package com.nit.weibo.utils;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSession;

public class SessionListener implements HttpSessionListener {
	private SessionContext sc = SessionContext.getInstance();

	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		sc.addSession(httpSessionEvent.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		HttpSession session = httpSessionEvent.getSession();
		sc.delSession(session);
	}
}