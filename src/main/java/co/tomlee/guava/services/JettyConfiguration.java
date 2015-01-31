package co.tomlee.guava.services;

public interface JettyConfiguration {
    int getPort();
    String getHost();

    int getStopTimeout();

    int getAcceptorThreadCount();
    int getSelectorThreadCount();
    int getAcceptQueueSize();
    long getConnectionIdleTimeout();
    boolean getReuseAddress();

    int getOutputBufferSize();
    int getRequestHeaderSize();
    int getResponseHeaderSize();

    int getMaxWorkerThreadCount();
    int getMinWorkerThreadCount();
    int getWorkerThreadIdleTimeout();
}
