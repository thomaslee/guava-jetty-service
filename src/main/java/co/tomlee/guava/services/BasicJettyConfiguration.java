package co.tomlee.guava.services;

public class BasicJettyConfiguration implements JettyConfiguration {
    private String host;
    private int port = 4040;

    private int stopTimeout = 5000;

    private int acceptorThreadCount = 4;
    private int selectorThreadCount = 16;
    private int acceptQueueSize = 100;

    private long idleTimeout = 30 * 1000;

    private boolean reuseAddress = true;

    private int outputBufferSize = 32 * 1024;
    private int requestHeaderSize = 4 * 1024;
    private int responseHeaderSize = 4 * 1024;

    private int minWorkerThreadCount = 100;
    private int maxWorkerThreadCount = 250;
    private int workerThreadIdleTimeout = 30 * 1000;

    public BasicJettyConfiguration() {

    }

    public BasicJettyConfiguration(final BasicJettyConfiguration jettyConfiguration) {
        this.host = jettyConfiguration.host;
        this.port = jettyConfiguration.port;
        this.stopTimeout = jettyConfiguration.stopTimeout;
        this.acceptorThreadCount = jettyConfiguration.acceptorThreadCount;
        this.selectorThreadCount = jettyConfiguration.selectorThreadCount;
        this.acceptQueueSize = jettyConfiguration.acceptQueueSize;
        this.idleTimeout = jettyConfiguration.idleTimeout;
        this.reuseAddress = jettyConfiguration.reuseAddress;
        this.outputBufferSize = jettyConfiguration.outputBufferSize;
        this.requestHeaderSize = jettyConfiguration.requestHeaderSize;
        this.responseHeaderSize = jettyConfiguration.responseHeaderSize;
        this.minWorkerThreadCount = jettyConfiguration.minWorkerThreadCount;
        this.maxWorkerThreadCount = jettyConfiguration.maxWorkerThreadCount;
        this.workerThreadIdleTimeout = jettyConfiguration.workerThreadIdleTimeout;
    }
    @Override
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public int getStopTimeout() {
        return stopTimeout;
    }

    public void setStopTimeout(final int stopTimeout) {
        this.stopTimeout = stopTimeout;
    }

    @Override
    public int getAcceptorThreadCount() {
        return acceptorThreadCount;
    }

    public void setAcceptorThreadCount(int acceptorThreadCount) {
        this.acceptorThreadCount = acceptorThreadCount;
    }

    @Override
    public int getSelectorThreadCount() {
        return selectorThreadCount;
    }

    public void setSelectorThreadCount(int selectorThreadCount) {
        this.selectorThreadCount = selectorThreadCount;
    }

    @Override
    public int getAcceptQueueSize() {
        return acceptQueueSize;
    }

    public void setAcceptQueueSize(int acceptQueueSize) {
        this.acceptQueueSize = acceptQueueSize;
    }

    @Override
    public long getConnectionIdleTimeout() {
        return idleTimeout;
    }

    public void setConnectionIdleTimeout(long idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public boolean getReuseAddress() {
        return reuseAddress;
    }

    public void setReuseAddress(boolean reuseAddress) {
        this.reuseAddress = reuseAddress;
    }

    @Override
    public int getOutputBufferSize() {
        return outputBufferSize;
    }

    public void setOutputBufferSize(int outputBufferSize) {
        this.outputBufferSize = outputBufferSize;
    }

    @Override
    public int getRequestHeaderSize() {
        return requestHeaderSize;
    }

    public void setRequestHeaderSize(int requestHeaderSize) {
        this.requestHeaderSize = requestHeaderSize;
    }

    @Override
    public int getResponseHeaderSize() {
        return responseHeaderSize;
    }

    public void setResponseHeaderSize(int responseHeaderSize) {
        this.responseHeaderSize = responseHeaderSize;
    }

    @Override
    public int getMinWorkerThreadCount() {
        return minWorkerThreadCount;
    }

    public void setMinWorkerThreadCount(int minWorkerThreadCount) {
        this.minWorkerThreadCount = minWorkerThreadCount;
    }

    @Override
    public int getMaxWorkerThreadCount() {
        return maxWorkerThreadCount;
    }

    public void setMaxWorkerThreadCount(int maxWorkerThreadCount) {
        this.maxWorkerThreadCount = maxWorkerThreadCount;
    }

    @Override
    public int getWorkerThreadIdleTimeout() {
        return workerThreadIdleTimeout;
    }

    public void setWorkerThreadIdleTimeout(int workerThreadIdleTimeout) {
        this.workerThreadIdleTimeout = workerThreadIdleTimeout;
    }
}
