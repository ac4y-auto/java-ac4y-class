package ac4y.base.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import ac4y.utility.GsonCap;
import ac4y.utility.JaxbCap;

@XmlRootElement
@MappedSuperclass
public class Ac4yIdentificationCommon {

	public Ac4yIdentificationCommon() {
		initGUID();
	}
	
	public Ac4yIdentificationCommon(String aGUID) {
		setGUID(aGUID);
	}
	
	public Ac4yIdentificationCommon(
			String aGUID
			,String aHumanID) {
		
		setGUID(aGUID);
		setHumanID(aHumanID);
		setPublicHumanID(aHumanID);
		
	}
	
	public Ac4yIdentificationCommon(
			int aPersistentID
			,String aGUID
			,String aHumanID
			,String aPublicHumanID
			) {
		
		setPersistentID(aPersistentID);
		setGUID(aGUID);
		setHumanID(aHumanID);
		setPublicHumanID(aPublicHumanID);
		
	}
	
	public Ac4yIdentificationCommon(
			int aPersistentID
			,String aGUID
			,String aHumanID
			,String aPublicHumanID
			,boolean aDeleted
			) {
		
		setPersistentID(aPersistentID);
		setGUID(aGUID);
		setHumanID(aHumanID);
		setPublicHumanID(aPublicHumanID);
		setDeleted(aDeleted);
		
	}
	
	@Id
//	@GeneratedValue
	//@Column(length=50)
	protected String GUID;

	public String getGUID() {
		return GUID;
	}

	public void setGUID(String gUID) {
		GUID = gUID;
	}

	public void initGUID(){
		GUID=java.util.UUID.randomUUID().toString();
	}
	
	protected String externalID;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected String name;
	
	//@Type(type="text") // import org.hibernate.annotations.Type;
	protected String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalID() {
		return externalID;
	}

	public void setExternalID(String externalID) {
		this.externalID = externalID;
	}

	public String getHumanID() {
		return humanID;
	}

	public void setHumanID(String humanID) {
		this.humanID = humanID;
	}

	private String humanID;
	
	public String getPersonalHumanID() {
		return personalHumanID;
	}

	public void setPersonalHumanID(String personalHumanID) {
		this.personalHumanID = personalHumanID;
	}

	private String personalHumanID;

	private String publicHumanID;
	
	public String getPublicHumanID() {
		return publicHumanID;
	}

	public void setPublicHumanID(String publicHumanID) {
		this.publicHumanID = publicHumanID;
	}

	private String internalHumanID;
	
	public String getInternalHumanID() {
		return internalHumanID;
	}

	public void setInternalHumanID(String internalHumanID) {
		this.internalHumanID = internalHumanID;
	}

	public String getParentHumanID() {
		return parentHumanID;
	}

	public void setParentHumanID(String parentHumanID) {
		this.parentHumanID = parentHumanID;
	}
	
	protected String parentHumanID;
	
	protected boolean deleted;
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	protected int persistentID = -2;

	public int getPersistentID() {
		return persistentID;
	}

	public void setPersistentID(int persistentID) {
		this.persistentID = persistentID;
	}

	protected String namespace;
	
	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getAsJson(){
		return new GsonCap().getObjectAsJson(this);
	}
	
	public Object getFromJson(String aJson){
		return new GsonCap().getFromJson(aJson, this.getClass());
	}
	
	public String getAsXml() throws JAXBException{
		return new JaxbCap().getObjectAsXmlString(this.getClass(), this);
	}

	public Object getFromXml(String aXml) throws JAXBException{
		return new JaxbCap().getObjectFromXmlString(this.getClass(), aXml);
	}

}