package ac4y.base.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ac4yClassTest {

    @Test
    public void testDefaultConstructor() {
        Ac4yClass ac4yClass = new Ac4yClass();
        assertNotNull(ac4yClass);
        assertNotNull(ac4yClass.getGUID());
    }

    @Test
    public void testConstructorWithHumanId() {
        String humanId = "testClass";
        Ac4yClass ac4yClass = new Ac4yClass(humanId);

        assertNotNull(ac4yClass);
        assertEquals(humanId, ac4yClass.getHumanId());
    }

    @Test
    public void testConstructorWithGUIDAndHumanId() {
        String guid = "test-guid-123";
        String humanId = "testClass";

        Ac4yClass ac4yClass = new Ac4yClass(guid, humanId);

        assertNotNull(ac4yClass);
        assertEquals(guid, ac4yClass.getGUID());
        assertEquals(humanId, ac4yClass.getHumanId());
    }

    @Test
    public void testSetAndGetHumanId() {
        Ac4yClass ac4yClass = new Ac4yClass();
        String humanId = "newHumanId";

        ac4yClass.setHumanId(humanId);

        assertEquals(humanId, ac4yClass.getHumanId());
    }

    @Test
    public void testSetAndGetGUID() {
        Ac4yClass ac4yClass = new Ac4yClass();
        String guid = "new-guid-456";

        ac4yClass.setGUID(guid);

        assertEquals(guid, ac4yClass.getGUID());
    }
}
