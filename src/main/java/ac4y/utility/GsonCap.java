package ac4y.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonCap {

    private Gson gson;

    public GsonCap() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public String getObjectAsJson(Object obj) {
        return gson.toJson(obj);
    }

    public <T> T getFromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
}
