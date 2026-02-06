package ac4y.base.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@MappedSuperclass
//@Entity
public class Ac4yObject {

	@Id
	protected String GUID;

	public String getGUID() {
		return GUID;
	}

	public void setGUID(String gUID) {
		GUID = gUID;
	}

	public Ac4yObject() {
		
		ac4yIdentification = new Ac4yIdentification();
		ac4yIdentification.initGUID();
		ac4yIdentification.setTemplate(new Ac4yClass());
		setGUID(getAc4yIdentification().getGUID());
		
	}

	public Ac4yObject(
			int aPersistentID
			,String aGUID
			,String aHumanID
			,String aPublicHumanID
			,String aTemplateGUID
			,String aTemplateHumanID
			,boolean aDeleted
			) {
		
		setAc4yIdentification(
			new Ac4yIdentification(
				aPersistentID
				,aGUID
				,aHumanID
				,aPublicHumanID
				,aTemplateGUID
				,aTemplateHumanID
				,aDeleted
			)
		);
		
	}

	public Ac4yObject(Ac4yIdentification ac4yIdentification) {
		setAc4yIdentification(ac4yIdentification);
	}
	
	@OneToOne
	///@Cascade({CascadeType.SAVE_UPDATE})
	protected Ac4yIdentification ac4yIdentification;
	
	public Ac4yIdentification getAc4yIdentification() {
		return ac4yIdentification;
	}

	public void setAc4yIdentification(Ac4yIdentification ac4yIdentification) {
		this.ac4yIdentification = ac4yIdentification;
	}
	
	///@Type(type="text")
	protected String serializing;

	public String getSerializing() {
		return serializing;
	}

	public void setSerializing(String serializing) {
		this.serializing = serializing;
	}
	
	public String getTemplateName() {
		return getAc4yIdentification().getTemplate().getHumanID();
	}
	
} // Ac4yObject