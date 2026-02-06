package ac4y.utility;

import org.jdom2.Element;

/**
 * JDOM XML handler for element extraction and property access.
 * Stub implementation to allow independent compilation.
 */
public class JDOMXMLHander {

    /**
     * Gets a child element by name from a container element.
     * @param container Parent element
     * @param elementName Name of the child element
     * @return Child element or null if not found
     */
    public Element getObject(Element container, String elementName) {
        if (container == null || elementName == null) {
            return null;
        }
        return container.getChild(elementName);
    }

    /**
     * Gets a property value from an element.
     * @param element Element containing the property
     * @param propertyName Name of the property element
     * @return Property value text or null if not found
     */
    public String getPropertyValue(Element element, String propertyName) {
        if (element == null || propertyName == null) {
            return null;
        }
        Element propertyElement = element.getChild(propertyName);
        if (propertyElement == null) {
            return null;
        }
        return propertyElement.getText();
    }

    /**
     * Gets a property value from a nested element structure.
     * @param container Parent container element
     * @param objectName Name of the intermediate object element
     * @param propertyName Name of the property element
     * @return Property value text or null if not found
     */
    public String getPropertyValue(Element container, String objectName, String propertyName) {
        if (container == null || objectName == null || propertyName == null) {
            return null;
        }
        Element objectElement = getObject(container, objectName);
        if (objectElement == null) {
            return null;
        }
        return getPropertyValue(objectElement, propertyName);
    }
}
