package com.nit.weibo.utils;

import java.util.HashMap;
import javax.servlet.http.HttpSession;

/**
 * @Description: WEB进行跨域访问的全局静态MAP，用于管理SESSION对象
 */
public class SessionContext {

	private static SessionContext instance;
	private HashMap<String, Object> mapSession;

	private SessionContext() {
		mapSession = new HashMap<String, Object>();
	}

	public static SessionContext getInstance() {
		if (instance == null) {
			instance = new SessionContext();
		}
		return instance;
	}

	public synchronized void addSession(HttpSession session) {
		if (session != null) {
			mapSession.put(session.getId(), session);
		}
	}

	public synchronized void delSession(HttpSession session) {
		if (session != null) {
			mapSession.remove(session.getId());
		}
	}

	public synchronized HttpSession getSession(String sessionId) {
		if (sessionId == null)
			return null;
		return (HttpSession) mapSession.get(sessionId);
	}
}
