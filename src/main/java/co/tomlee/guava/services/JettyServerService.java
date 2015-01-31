package co.tomlee.guava.services;

import com.google.common.util.concurrent.AbstractIdleService;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;

import javax.inject.Inject;
import java.util.Arrays;

public class JettyServerService extends AbstractIdleService {
    private final JettyConfiguration configuration;
    private final Handler handler;
    private Server server;

    @Inject
    public JettyServerService(final JettyConfiguration configuration,
                              final Handler handler) {
        this.configuration = configuration;
        this.handler = handler;
    }

    @Override
    protected void startUp() throws Exception {
        server = new Server(createThreadPool());
        Handler handler = this.handler;
        if (configuration().getStopTimeout() > 0) {
            final StatisticsHandler statisticsHandler = new StatisticsHandler();
            statisticsHandler.setHandler(handler);
            handler = statisticsHandler;
        }
        server.setHandler(handler);
        if (configuration.getStopTimeout() > 0) {
            server.setStopTimeout(configuration.getStopTimeout());
        }
        server.setConnectors(createServerConnectors(createConnectionFactories()));
        server.start();
    }

    @Override
    protected void shutDown() throws Exception {
        server.stop();
    }

    protected final JettyConfiguration configuration() {
        return configuration;
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
