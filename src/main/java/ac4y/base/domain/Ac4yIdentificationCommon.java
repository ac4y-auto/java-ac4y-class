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
			,String aHumanId) {
		
		setGUID(aGUID);
		setHumanId(aHumanId);
		setPublicHumanId(aHumanId);
		
	}
	
	public Ac4yIdentificationCommon(
			int aPersistentId
			,String aGUID
			,String aHumanId
			,String aPublicHumanId
			) {
		
		setPersistentId(aPersistentId);
		setGUID(aGUID);
		setHumanId(aHumanId);
		setPublicHumanId(aPublicHumanId);
		
	}
	
	public Ac4yIdentificationCommon(
			int aPersistentId
			,String aGUID
			,String aHumanId
			,String aPublicHumanId
			,boolean aDeleted
			) {
		
		setPersistentId(aPersistentId);
		setGUID(aGUID);
		setHumanId(aHumanId);
		setPublicHumanId(aPublicHumanId);
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
	
	protected String externalId;
	
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

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getHumanId() {
		return humanId;
	}

	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}

	private String humanId;
	
	public String getPersonalHumanId() {
		return personalHumanId;
	}

	public void setPersonalHumanId(String personalHumanId) {
		this.personalHumanId = personalHumanId;
	}

	private String personalHumanId;

	private String publicHumanId;
	
	public String getPublicHumanId() {
		return publicHumanId;
	}

	public void setPublicHumanId(String publicHumanId) {
		this.publicHumanId = publicHumanId;
	}

	private String internalHumanId;
	
	public String getInternalHumanId() {
		return internalHumanId;
	}

	public void setInternalHumanId(String internalHumanId) {
		this.internalHumanId = internalHumanId;
	}

	public String getParentHumanId() {
		return parentHumanId;
	}

	public void setParentHumanId(String parentHumanId) {
		this.parentHumanId = parentHumanId;
	}
	
	protected String parentHumanId;
	
	protected boolean deleted;
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	protected int persistentId = -2;

	public int getPersistentId() {
		return persistentId;
	}

	public void setPersistentId(int persistentId) {
		this.persistentId = persistentId;
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