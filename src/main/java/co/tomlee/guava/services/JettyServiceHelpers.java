package co.tomlee.guava.services;

public final class JettyServiceHelpers {

    public static BindingServletHandler bindings() {
        return new BindingServletHandler();
    }

    public static BasicJettyConfiguration port(final int port) {
        final BasicJettyConfiguration jettyConfiguration = new BasicJettyConfiguration();
        jettyConfiguration.setPort(port);
        return jettyConfiguration;
    }

    private JettyServiceHelpers() {}
}
