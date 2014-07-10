package co.tomlee.guava.services;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

import java.io.IOException;

import static co.tomlee.guava.services.JettyServiceHelpers.*;

public class JettyServiceTest {
    private JettyService jettyService;

    @Before
    public void before() throws Exception {
        jettyService = new JettyService(port(44244), bindings().bind("/get-servlet", new GetServlet()));
        jettyService.startAsync().awaitRunning();
    }

    @After
    public void after() {
        if (jettyService != null) {
            jettyService.stopAsync().awaitTerminated();
        }
    }

    @Test
    public void trivial() throws Exception {
        final HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            final HttpResponse resp = httpClient.execute(new HttpGet("http://localhost:44244/get-servlet"));
            try {
                final String data = IOUtils.toString(resp.getEntity().getContent());
                assertEquals("Hello World", data);
            }
            finally {
                HttpClientUtils.closeQuietly(resp);
            }
        }
        finally {
            HttpClientUtils.closeQuietly(httpClient);
        }
    }

    private static final class GetServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.getWriter().print("Hello World");
        }
    }
}
