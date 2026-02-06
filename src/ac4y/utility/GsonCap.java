package ac4y.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Gson capability wrapper for JSON serialization/deserialization.
 * Stub implementation to allow independent compilation.
 */
public class GsonCap {

    private Gson gson;

    public GsonCap() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Converts an object to JSON string.
     * @param object The object to serialize
     * @return JSON string representation
     */
    public String getObjectAsJson(Object object) {
        if (object == null) {
            return "null";
        }
        return gson.toJson(object);
    }

    /**
     * Converts JSON string to object.
     * @param json JSON string to deserialize
     * @param clazz Target class type
     * @return Deserialized object
     */
    public Object getFromJson(String json, Class<?> clazz) {
        if (json == null || json.isEmpty()) {
            return null;
        }
        return gson.fromJson(json, clazz);
    }
}
