package ro.szzsa.livescore.api.device.client.impl.http.connector;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import ro.szzsa.livescore.api.device.client.log.Logger;

public class HttpConnector implements Connector {

    private final int connectionTimeout;

    private final int socketTimeout;

    private final int numberOfRetries;

    private final Logger logger;

    public HttpConnector(int connectionTimeout, int socketTimeout, int numberOfRetries, Logger logger) {
        this.connectionTimeout = connectionTimeout;
        this.socketTimeout = socketTimeout;
        this.numberOfRetries = numberOfRetries;
        this.logger = logger;
    }

    @Override
    public String sendRequest(Request request) throws ConnectorException {
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, connectionTimeout);
        HttpConnectionParams.setSoTimeout(httpParameters, socketTimeout);
        HttpClient httpClient = new DefaultHttpClient(httpParameters);
        HttpResponse httpResponse = null;
        int currentRetries = 0;
        boolean requestSent = false;
        logger.debug("|---> Sending request to " + request.getUrl() + "\n" +
                     (request.getMessage() == null ? "" : request.getMessage()));
        while (!requestSent && currentRetries < numberOfRetries) {
            try {
                httpResponse = httpClient.execute(getHttpRequest(request));
                requestSent = true;
            } catch (IOException e) {
                currentRetries++;
                if (!(currentRetries < numberOfRetries)) {
                    throw new ConnectorException("Cannot connect to " + request.getUrl(), e);
                } else {
                    logger.error("Cannot connect to " + request.getUrl() + ", retrying...");
                }
            }
        }
        HttpEntity entity = httpResponse != null ? httpResponse.getEntity() : null;
        String response = null;
        if (entity != null) {
            InputStream inputStream = null;
            try {
                inputStream = entity.getContent();
                StringWriter writer = new StringWriter();
                IOUtils.copy(inputStream, writer);
                response = writer.toString();
                inputStream.close();
            } catch (IOException e) {
                throw new ConnectorException(e);
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
        logger.debug("|<--- Received response from " + request.getUrl() + "\n" + response);
        return response;
    }

    private HttpRequestBase getHttpRequest(Request request) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(request.getUrl());
        if (request.getMessage() != null) {
            httpPost.addHeader("content-type", "application/json; charset=utf-8");
            httpPost.setEntity(new StringEntity(request.getMessage()));
        }
        return httpPost;
    }
}
