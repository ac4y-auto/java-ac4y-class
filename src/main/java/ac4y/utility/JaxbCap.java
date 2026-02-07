package ac4y.utility;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JaxbCap {

    @SuppressWarnings("unchecked")
    public String getObjectAsXmlString(Class<?> clazz, Object obj) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        return writer.toString();
    }

    @SuppressWarnings("unchecked")
    public Object getObjectFromXmlString(Class<?> clazz, String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader reader = new StringReader(xml);
        return unmarshaller.unmarshal(reader);
    }
}
