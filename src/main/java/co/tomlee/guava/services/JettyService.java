package co.tomlee.guava.services;

import com.google.common.util.concurrent.AbstractIdleService;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;

import javax.inject.Inject;
import java.util.Arrays;

public class JettyService extends AbstractIdleService {
    private final JettyConfiguration jettyConfiguration;
    private final Handler handler;
    private Server server;

    @Inject
    public JettyService(final JettyConfiguration jettyConfiguration,
                        final Handler handler) {
        this.jettyConfiguration = jettyConfiguration;
        this.handler = handler;
    }

    @Override
    protected void startUp() throws Exception {
        server = new Server(createThreadPool());
        server.setHandler(handler);
        server.setConnectors(createServerConnectors(createConnectionFactories()));
        server.start();
    }

    @Override
    protected void shutDown() throws Exception {
        server.stop();
        server.join();
    }

    protected final JettyConfiguration configuration() {
        return jettyConfiguration;
    }

    protected ThreadPool createThreadPool() {
        return new QueuedThreadPool(
            configuration().getMaxWorkerThreadCount(),
            configuration().getMinWorkerThreadCount(),
            configuration().getWorkerThreadIdleTimeout()
        );
    }

    protected ServerConnector[] createServerConnectors(final ConnectionFactory[] connectionFactories) {
        final ServerConnector serverConnector =
            new ServerConnector(server,
                                configuration().getAcceptorThreadCount(),
                                configuration().getSelectorThreadCount());
        serverConnector.setPort(configuration().getPort());
        serverConnector.setAcceptQueueSize(configuration().getAcceptQueueSize());
        serverConnector.setIdleTimeout(configuration().getConnectionIdleTimeout());
        serverConnector.setReuseAddress(configuration().getReuseAddress());
        if (configuration().getHost() != null) {
            serverConnector.setHost(configuration().getHost());
        }
        serverConnector.setStopTimeout(configuration().getStopTimeout());
        serverConnector.setConnectionFactories(Arrays.asList(connectionFactories));
        return new ServerConnector[] { serverConnector };
    }

    protected ConnectionFactory[] createConnectionFactories() {
        final HttpConfiguration httpConfiguration = new HttpConfiguration();
        httpConfiguration.setOutputBufferSize(configuration().getOutputBufferSize());
        httpConfiguration.setRequestHeaderSize(configuration().getRequestHeaderSize());
        httpConfiguration.setResponseHeaderSize(configuration().getResponseHeaderSize());
        return new ConnectionFactory[] { new HttpConnectionFactory(httpConfiguration) };
    }
}
