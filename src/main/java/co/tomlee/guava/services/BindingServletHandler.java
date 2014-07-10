package co.tomlee.guava.services;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;
import java.util.UUID;

public class BindingServletHandler extends ServletContextHandler {
    public BindingServletHandler() {
        super(NO_SESSIONS);
    }

    public final BindingServletHandler bind(final String path, final HttpServlet httpServlet) {
        final String name = "servlet-" + UUID.randomUUID().toString();
        return bind(name, path, httpServlet);
    }

    public final BindingServletHandler bind(final String name, final String path, final HttpServlet httpServlet) {
        addServlet(new ServletHolder(name, httpServlet), path);
        return this;
    }
}
