package br.gov.frameworkdemoiselle.util;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import br.gov.frameworkdemoiselle.lifecycle.AfterSessionCreated;
import br.gov.frameworkdemoiselle.lifecycle.BeforeSessionDestroyed;

/**
 * <p>Implements the {@link HttpSessionListener} interface and fires two events.</p>
 * 
 * <ul>
 * <li><strong>{@link AfterSessionCreated}</strong>: Just after a new HTTP session is created</li>
 * <li><strong>{@link BeforeSessionDestroyed}</strong>: Just before an HTTP session is invalidated</li>
 * </ul>
 * 
 * @author serpro
 *
 */
public class SessionListener implements HttpSessionListener {
	
	@Override
	public void sessionCreated(final HttpSessionEvent sessionEvent) {
		Beans.getBeanManager().fireEvent(new AfterSessionCreated() {
			@Override
			public HttpSession getSession() {
				return sessionEvent.getSession();
			}
		});
	}

	@Override
	public void sessionDestroyed(final HttpSessionEvent sessionEvent) {
		Beans.getBeanManager().fireEvent(new BeforeSessionDestroyed() {
			@Override
			public HttpSession getSession() {
				return sessionEvent.getSession();
			}
		});
	}
}
