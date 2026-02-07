package ac4y.utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GsonCapTest {

    static class TestObject {
        private String name;
        private int value;

        public TestObject() {}

        public TestObject(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getValue() { return value; }
        public void setValue(int value) { this.value = value; }
    }

    @Test
    public void testGetObjectAsJson() {
        GsonCap gsonCap = new GsonCap();
        TestObject obj = new TestObject("test", 42);

        String json = gsonCap.getObjectAsJson(obj);

        assertNotNull(json);
        assertTrue(json.contains("\"name\""));
        assertTrue(json.contains("\"test\""));
        assertTrue(json.contains("\"value\""));
        assertTrue(json.contains("42"));
    }

    @Test
    public void testGetFromJson() {
        GsonCap gsonCap = new GsonCap();
        String json = "{\"name\":\"test\",\"value\":42}";

        TestObject obj = gsonCap.getFromJson(json, TestObject.class);

        assertNotNull(obj);
        assertEquals("test", obj.getName());
        assertEquals(42, obj.getValue());
    }

    @Test
    public void testRoundTrip() {
        GsonCap gsonCap = new GsonCap();
        TestObject original = new TestObject("roundtrip", 100);

        String json = gsonCap.getObjectAsJson(original);
        TestObject restored = gsonCap.getFromJson(json, TestObject.class);

        assertEquals(original.getName(), restored.getName());
        assertEquals(original.getValue(), restored.getValue());
    }
}
