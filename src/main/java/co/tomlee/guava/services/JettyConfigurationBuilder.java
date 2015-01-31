package co.tomlee.guava.services;

public final class JettyConfigurationBuilder {
    private BasicJettyConfiguration config = new BasicJettyConfiguration();

    public static JettyConfigurationBuilder builder() {
        return new JettyConfigurationBuilder();
    }

    public JettyConfigurationBuilder setHost(final String host) {
        this.config.setHost(host);
        return this;
    }

    public JettyConfigurationBuilder setAcceptorThreadCount(final int acceptorThreadCount) {
        this.config.setAcceptorThreadCount(acceptorThreadCount);
        return this;
    }

    public JettyConfigurationBuilder setSelectorThreadCount(final int selectorThreadCount) {
        this.config.setSelectorThreadCount(selectorThreadCount);
        return this;
    }

    public JettyConfigurationBuilder setAcceptQueueSize(final int acceptQueueSize) {
        this.config.setAcceptQueueSize(acceptQueueSize);
        return this;
    }

    public JettyConfigurationBuilder setConnectionIdleTimeout(final long idleTimeout) {
        this.config.setConnectionIdleTimeout(idleTimeout);
        return this;
    }

    public JettyConfigurationBuilder setReuseAddress(final boolean reuseAddress) {
        this.config.setReuseAddress(reuseAddress);
        return this;
    }

    public JettyConfigurationBuilder setOutputBufferSize(final int outputBufferSize) {
        this.config.setOutputBufferSize(outputBufferSize);
        return this;
    }

    public JettyConfigurationBuilder setRequestHeaderSize(final int requestHeaderSize) {
        this.config.setRequestHeaderSize(requestHeaderSize);
        return this;
    }

    public JettyConfigurationBuilder setResponseHeaderSize(final int responseHeaderSize) {
        this.config.setResponseHeaderSize(responseHeaderSize);
        return this;
    }

    public JettyConfigurationBuilder setMaxWorkerThreadCount(final int maxWorkerThreadCount) {
        this.config.setMaxWorkerThreadCount(maxWorkerThreadCount);
        return this;
    }

    public JettyConfigurationBuilder setMinWorkerThreadCount(final int minWorkerThreadCount) {
        this.config.setMinWorkerThreadCount(minWorkerThreadCount);
        return this;
    }

    public JettyConfigurationBuilder setWorkerThreadIdleTimeout(final int workerThreadIdleTimeout) {
        this.config.setWorkerThreadIdleTimeout(workerThreadIdleTimeout);
        return this;
    }

    public JettyConfigurationBuilder setStopTimeout(final int stopTimeout) {
        this.config.setStopTimeout(stopTimeout);
        return this;
    }

    public JettyConfiguration build(final int port) {
        final BasicJettyConfiguration config = new BasicJettyConfiguration(this.config);
        config.setPort(port);
        return config;
    }
}
