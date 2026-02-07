package ac4y.utility;

import org.jdom2.Element;

public class JDOMXMLHander {

    public Element getObject(Element container, String objectName) {
        if (container == null) {
            return null;
        }
        return container.getChild(objectName);
    }

    public String getPropertyValue(Element object, String propertyName) {
        if (object == null) {
            return null;
        }
        Element property = object.getChild(propertyName);
        if (property == null) {
            return null;
        }
        return property.getTextTrim();
    }

    public String getPropertyValue(Element container, String objectName, String propertyName) {
        Element object = getObject(container, objectName);
        return getPropertyValue(object, propertyName);
    }
}
