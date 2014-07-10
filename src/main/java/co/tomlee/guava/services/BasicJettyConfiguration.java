package co.tomlee.guava.services;

public class BasicJettyConfiguration implements JettyConfiguration {
        private String host;
    private int port = 4040;

    private long stopTimeout = 5 * 1000;

    private int acceptorThreadCount = 4;
    private int selectorThreadCount = 16;
    private int acceptQueueSize = 100;

    private long idleTimeout = 30 * 1000;

    private boolean reuseAddress = true;

    private int outputBufferSize = 32 * 1024;
    private int requestHeaderSize = 4 * 1024;
    private int responseHeaderSize = 4 * 1024;

    private int minWorkerThreadCount = 100;
    private int maxWorkerThreadcount = 250;
    private int workerThreadTimeout = 30 * 1000;

     @Override
    public int getPort() {
        return port;
    }

    public void setPort(final int port) {
        this.port = port;
    }

    @Override
    public String getHost() {
        return host;
    }

    public void setHost(final String host) {
        this.host = host;
    }

    @Override
    public long getStopTimeout() {
        return stopTimeout;
    }

    public void setStopTimeout(final long stopTimeout) {
        this.stopTimeout = stopTimeout;
    }

    @Override
    public int getAcceptorThreadCount() {
        return acceptorThreadCount;
    }

    public void setAcceptorThreadCount(final int acceptorThreadCount) {
        this.acceptorThreadCount = acceptorThreadCount;
    }

    @Override
    public int getSelectorThreadCount() {
        return selectorThreadCount;
    }

    public void setSelectorThreadCount(final int selectorThreadCount) {
        this.selectorThreadCount = selectorThreadCount;
    }

    @Override
    public int getAcceptQueueSize() {
        return acceptQueueSize;
    }

    public void setAcceptQueueSize(final int acceptQueueSize) {
        this.acceptQueueSize = acceptQueueSize;
    }

    @Override
    public long getConnectionIdleTimeout() {
        return idleTimeout;
    }

    public void setConnectionIdleTimeout(final long idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

     @Override
    public boolean getReuseAddress() {
        return reuseAddress;
    }

    public void setReuseAddress(final boolean reuseAddress) {
        this.reuseAddress = reuseAddress;
    }

    @Override
    public int getOutputBufferSize() {
        return outputBufferSize;
    }

    public void setOutputBufferSize(final int outputBufferSize) {
        this.outputBufferSize = outputBufferSize;
    }

    @Override
    public int getRequestHeaderSize() {
        return requestHeaderSize;
    }

    public void setRequestHeaderSize(final int requestHeaderSize) {
        this.requestHeaderSize = requestHeaderSize;
    }

    @Override
    public int getResponseHeaderSize() {
        return responseHeaderSize;
    }

    public void setResponseHeaderSize(final int responseHeaderSize) {
        this.responseHeaderSize = responseHeaderSize;
    }

    @Override
    public int getMaxWorkerThreadCount() {
        return maxWorkerThreadcount;
    }

    public void setMaxWorkerThreadcount(final int maxWorkerThreadcount) {
        this.maxWorkerThreadcount = maxWorkerThreadcount;
    }

    @Override
    public int getMinWorkerThreadCount() {
        return minWorkerThreadCount;
    }

    public void setMinWorkerThreadCount(final int minWorkerThreadCount) {
        this.minWorkerThreadCount = minWorkerThreadCount;
    }

    @Override
    public int getWorkerThreadIdleTimeout() {
        return workerThreadTimeout;
    }

    public void setWorkerThreadIdleTimeout(final int workerThreadIdleTimeout) {
        this.workerThreadTimeout = workerThreadIdleTimeout;
    }
}
