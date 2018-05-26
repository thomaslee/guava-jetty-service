package co.tomlee.guava.services;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.ArrayList;
import java.util.EnumSet;

public final class JettyHandlerBuilder {
    private int flags = ServletContextHandler.NO_SESSIONS;
    private final ArrayList<ServletBinding> servletBindings = new ArrayList<>();
    private final ArrayList<FilterBinding> filterBindings = new ArrayList<>();

    public static JettyHandlerBuilder builder() {
        return new JettyHandlerBuilder();
    }

    public JettyHandlerBuilder enableSessions() {
        flags |= ServletContextHandler.SESSIONS;
        return this;
    }

    public JettyHandlerBuilder disableSessions() {
        flags &= ~ServletContextHandler.SESSIONS;
        return this;
    }

    public JettyHandlerBuilder enableSecurity() {
        flags |= ServletContextHandler.SECURITY;
        return this;
    }

    public JettyHandlerBuilder disableSecurity() {
        flags &= ~ServletContextHandler.SECURITY;
        return this;
    }

    public ServletBinder bind(final Servlet servlet) {
        return new ServletBinder(servlet);
    }

    public FilterBinder bind(final Filter filter) {
        return new FilterBinder(filter);
    }

    public Handler build() {
        final ServletContextHandler handler = new ServletContextHandler(flags);
        for (final FilterBinding filterBinding : filterBindings) {
            handler.addFilter(filterBinding.getHolder(), filterBinding.getPath(), filterBinding.getDispatches());
        }
        for (final ServletBinding servletBinding : servletBindings) {
            handler.addServlet(servletBinding.getHolder(), servletBinding.getPath());
        }
        return handler;
    }

    public final class FilterBinder {
        private final Filter filter;
        private final EnumSet<DispatcherType> dispatches = EnumSet.of(DispatcherType.REQUEST);

        public FilterBinder(final Filter filter) {
            this.filter = filter;
        }

        public FilterBinder withAsyncDispatch() {
            dispatches.add(DispatcherType.ASYNC);
            return this;
        }

        public FilterBinder withRequestDispatch() {
            dispatches.add(DispatcherType.REQUEST);
            return this;
        }

        public FilterBinder withIncludeDispatch() {
            dispatches.add(DispatcherType.INCLUDE);
            return this;
        }

        public FilterBinder withErrorDispatch() {
            dispatches.add(DispatcherType.ERROR);
            return this;
        }

        public FilterBinder withForwardDispatch() {
            dispatches.add(DispatcherType.FORWARD);
            return this;
        }

        public JettyHandlerBuilder to(final String path) {
            filterBindings.add(new FilterBinding(new FilterHolder(filter), path, dispatches));
            return JettyHandlerBuilder.this;
        }
    }

    public final class ServletBinder {
        private final Servlet servlet;

        public ServletBinder(final Servlet servlet) {
            this.servlet = servlet;
        }

        public JettyHandlerBuilder to(final String path) {
            servletBindings.add(new ServletBinding(new ServletHolder("servlet-" + servletBindings.size(), servlet), path));
            return JettyHandlerBuilder.this;
        }
    }

    private static final class FilterBinding {
        private final FilterHolder holder;
        private final String path;
        private final EnumSet<DispatcherType> dispatches;

        public FilterBinding(final FilterHolder filterHolder, final String path, final EnumSet<DispatcherType> dispatches) {
            this.holder = filterHolder;
            this.path = path;
            this.dispatches = dispatches;
        }

        public FilterHolder getHolder() {
            return holder;
        }

        public String getPath() {
            return path;
        }

        public EnumSet<DispatcherType> getDispatches() {
            return dispatches;
        }
    }

    private static final class ServletBinding {
        private final ServletHolder holder;
        private final String path;

        public ServletBinding(final ServletHolder holder, final String path) {
            this.holder = holder;
            this.path = path;
        }

        public ServletHolder getHolder() {
            return holder;
        }

        public String getPath() {
            return path;
        }
    }
}
