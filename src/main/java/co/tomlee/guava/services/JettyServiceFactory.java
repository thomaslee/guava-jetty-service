package co.tomlee.guava.services;

import org.eclipse.jetty.server.Handler;

public class JettyServiceFactory {
    public JettyService newJettyService(final JettyConfiguration jettyConfiguration, final Handler handler) {
        return new JettyService(jettyConfiguration, handler);
    }
}
