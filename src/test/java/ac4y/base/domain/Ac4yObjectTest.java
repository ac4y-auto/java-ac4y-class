package ac4y.base.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ac4yObjectTest {

    @Test
    public void testDefaultConstructor() {
        Ac4yObject obj = new Ac4yObject();

        assertNotNull(obj);
        assertNotNull(obj.getAc4yIdentification());
        assertNotNull(obj.getGUID());
        assertNotNull(obj.getAc4yIdentification().getTemplate());
    }

    @Test
    public void testConstructorWithIdentification() {
        Ac4yIdentification identification = new Ac4yIdentification();
        identification.setHumanId("testId");

        Ac4yObject obj = new Ac4yObject(identification);

        assertNotNull(obj);
        assertEquals(identification, obj.getAc4yIdentification());
        assertEquals("testId", obj.getAc4yIdentification().getHumanId());
    }

    @Test
    public void testGetTemplateName() {
        Ac4yObject obj = new Ac4yObject();
        obj.getAc4yIdentification().getTemplate().setHumanId("TestTemplate");

        assertEquals("TestTemplate", obj.getTemplateName());
    }

    @Test
    public void testSetAndGetSerializing() {
        Ac4yObject obj = new Ac4yObject();
        String serializing = "test serializing data";

        obj.setSerializing(serializing);

        assertEquals(serializing, obj.getSerializing());
    }

    @Test
    public void testGUIDPersistence() {
        Ac4yObject obj = new Ac4yObject();
        String guid = obj.getGUID();

        assertNotNull(guid);
        assertEquals(guid, obj.getAc4yIdentification().getGUID());
    }
}
