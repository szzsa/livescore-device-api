package ro.szzsa.livescore.api.device.client.connector;

/**
 *
 */
public class Request {

    private String url;

    private String message;

    public Request(String url) {
        this.url = url;
    }

    public Request(String url, String message) {
        this.url = url;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public String getMessage() {
        return message;
    }
}
