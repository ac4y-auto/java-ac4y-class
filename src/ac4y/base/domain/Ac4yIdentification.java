package ac4y.base.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Ac4yIdentification extends Ac4yIdentificationCommon {

	public static Ac4yIdentification createAc4yIdentificationByHumanID(String aHumanID) {
		Ac4yIdentification ac4yIdentification = new Ac4yIdentification();
		ac4yIdentification.setHumanID(aHumanID);
		return ac4yIdentification;
	}
	
	public Ac4yIdentification() {
		setTemplate(new Ac4yClass());
	}
	
	public Ac4yIdentification(String aGUID) {
		setTemplate(new Ac4yClass());
		setGUID(aGUID);
	}
	
	public Ac4yIdentification(
			String aGUID
			,String aHumanID) {
		super(aGUID, aHumanID);
		setTemplate(new Ac4yClass());
	}
	
	public Ac4yIdentification(
			String aGUID
			,String aTemplateHumanID
			,String aHumanID
			) {
		
		super(aGUID, aHumanID);
		setTemplate(new Ac4yClass());
		getTemplate().setHumanID(aTemplateHumanID);
		
	}
	
	public Ac4yIdentification(
			Ac4yClass aAc4yClass
			,String aHumanID
			) {
		
		setHumanID(aHumanID);
		setTemplate(aAc4yClass);
		
	}
	
	public Ac4yIdentification(
			Ac4yClass aAc4yClass
			,String aGUID
			,String aHumanID
			) {
		
		////setGUID(aGUID);
		setHumanID(aHumanID);
		setTemplate(aAc4yClass);
		
	}
	
	public Ac4yIdentification(
			int aPersistentID
			,String aGUID
			,String aHumanID
			,String aPublicHumanID
			,String aTemplateGUID
			,String aTemplateHumanID
			,boolean aDeleted
			) {
		super(
			aPersistentID
			,aGUID
			,aHumanID
			,aPublicHumanID
			,aDeleted
		);
		
		setTemplate(new Ac4yClass());
		////getTemplate().setGUID(aTemplateGUID);
		getTemplate().setHumanID(aTemplateHumanID);

	}
	
	public Ac4yIdentification(
			int aPersistentID
			,String aGUID
			,String aHumanID
			,String aPublicHumanID
			,boolean aDeleted
			,Ac4yClass aTemplate
			) {
		
		super(
				aPersistentID
				,aGUID
				,aHumanID
				,aPublicHumanID
				,aDeleted
			);
		
		setTemplate(aTemplate);

	}
	
	@OneToOne
//	@Cascade({CascadeType.SAVE_UPDATE}) // import org.hibernate.annotations.CascadeType;

	protected Ac4yClass template;
	
	public Ac4yClass getTemplate() {
		return template;
	}

	public void setTemplate(Ac4yClass template) {
		this.template = template;
	}

}