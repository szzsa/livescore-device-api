package ro.szzsa.livescore.api.device.client.impl.http.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Used to convert objects from/to Json.
 */
public class JsonConverter implements Converter {

    private Gson gson;

    public JsonConverter() {
        gson = new GsonBuilder().create();
    }

    @Override
    public String toString(Object object) {
        return gson.toJson(object);
    }

    @Override
    public <T> T fromString(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }
}
