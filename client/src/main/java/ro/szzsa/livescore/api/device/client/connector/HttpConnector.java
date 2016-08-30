package ro.szzsa.livescore.api.device.client.connector;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import ro.szzsa.livescore.api.device.client.connector.log.Logger;
import ro.szzsa.livescore.api.device.client.connector.log.Loggers;

public class HttpConnector implements Connector {

    private static final int SOCKET_TIMEOUT = 5000;

    private int numberOfRetries = 4;

    private Logger logger = Loggers.createEmptyLogger();

    @Override
    public String sendRequest(Request request) throws ConnectorException {
        int currentRetries = 0;
        Throwable exception = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        logger.debug("|---> Sending request to " + request.getUrl() + "\n" +
                     (request.getMessage() == null ? "" : request.getMessage()));
        int connectionTimeout = 2000;
        while (currentRetries <= numberOfRetries) {
            try (CloseableHttpResponse httpResponse = httpclient.execute(buildHttpPost(request, connectionTimeout))) {
                String response = getResponseMessage(httpResponse.getEntity());
                logger.debug("|<--- Received response from " + request.getUrl() + "\n" + response);
                return response;
            } catch (IOException e) {
                currentRetries++;
                logger.warn("Cannot connect to " + request.getUrl());
                exception = e;
                if (currentRetries <= numberOfRetries) {
                    logger.debug("retrying...");
                }
            }
        }
        throw new ConnectorException("Cannot connect to " + request.getUrl(), exception);
    }

    private String getResponseMessage(HttpEntity entity) throws ConnectorException {
        String response;
        try (InputStream inputStream = entity.getContent()) {
            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer, Charset.forName("utf-8"));
            response = writer.toString();
            EntityUtils.consume(entity);
        } catch (IOException e) {
            throw new ConnectorException(e);
        }
        return response;
    }

    private HttpPost buildHttpPost(Request request, int connectionTimeout) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(request.getUrl());
        RequestConfig config = RequestConfig.custom()
                                   .setSocketTimeout(SOCKET_TIMEOUT)
                                   .setConnectTimeout(connectionTimeout)
                                   .build();
        httpPost.setConfig(config);
        if (request.getMessage() != null) {
            httpPost.addHeader("content-type", "application/json; charset=utf-8");
            httpPost.setEntity(new StringEntity(request.getMessage()));
        }
        return httpPost;
    }

    public void setNumberOfRetries(int numberOfRetries) {
        this.numberOfRetries = numberOfRetries;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
