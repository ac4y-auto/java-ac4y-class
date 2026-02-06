package ac4y.base.service;

import org.jdom2.Element;

import ac4y.utility.JDOMXMLHander;
 
public class Ac4yIdentificationDomBuilder {

	public Element getObject(Element aContainer){
		
		return
			new JDOMXMLHander().getObject(
				aContainer
				,"ac4yIdentification"
			);
		
	} // getObject
	
	public String getGUIDProperty(Element aObject){
		
		return
			new JDOMXMLHander().getPropertyValue(
				aObject
				,"GUID"
			);
		
	} // getGUIDProperty
	
	public String getGUID(Element aContainer){
		
		return
			new JDOMXMLHander().getPropertyValue(
				aContainer
				,"ac4yIdentification"
				,"GUID"
			);
/*
			new JDOMXMLHander().getPropertyValue(
				new JDOMXMLHander().getObject(
					aContainer
					,"ac4yIdentification"
				)
				,"GUID"
			);
*/
	} // getGUID
	
	public Element getTemplateObject(Element aContainer){
		
		return
			new JDOMXMLHander().getObject(
				getObject(aContainer)
				,"template"
			);
		
	} // getTemplateObject
	
	public String getTemplateGUID(Element aContainer){
		
		return
			getGUIDProperty(
				getTemplateObject(aContainer)
			);
		
	} // getTemplateGUID
	
}
