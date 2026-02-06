package ac4y.utility;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * JAXB capability wrapper for XML serialization/deserialization.
 * Stub implementation to allow independent compilation.
 */
public class JaxbCap {

    /**
     * Converts an object to XML string.
     * @param clazz Class type of the object
     * @param object The object to serialize
     * @return XML string representation
     * @throws JAXBException if serialization fails
     */
    public String getObjectAsXmlString(Class<?> clazz, Object object) throws JAXBException {
        if (object == null) {
            return "";
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(object, writer);
        return writer.toString();
    }

    /**
     * Converts XML string to object.
     * @param clazz Target class type
     * @param xml XML string to deserialize
     * @return Deserialized object
     * @throws JAXBException if deserialization fails
     */
    public Object getObjectFromXmlString(Class<?> clazz, String xml) throws JAXBException {
        if (xml == null || xml.isEmpty()) {
            return null;
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        return unmarshaller.unmarshal(reader);
    }
}
