package ac4y.base.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Ac4yIdentification extends Ac4yIdentificationCommon {

	public static Ac4yIdentification createAc4yIdentificationByHumanId(String aHumanId) {
		Ac4yIdentification ac4yIdentification = new Ac4yIdentification();
		ac4yIdentification.setHumanId(aHumanId);
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
			,String aHumanId) {
		super(aGUID, aHumanId);
		setTemplate(new Ac4yClass());
	}
	
	public Ac4yIdentification(
			String aGUID
			,String aTemplateHumanId
			,String aHumanId
			) {
		
		super(aGUID, aHumanId);
		setTemplate(new Ac4yClass());
		getTemplate().setHumanId(aTemplateHumanId);
		
	}
	
	public Ac4yIdentification(
			Ac4yClass aAc4yClass
			,String aHumanId
			) {
		
		setHumanId(aHumanId);
		setTemplate(aAc4yClass);
		
	}
	
	public Ac4yIdentification(
			Ac4yClass aAc4yClass
			,String aGUID
			,String aHumanId
			) {
		
		////setGUID(aGUID);
		setHumanId(aHumanId);
		setTemplate(aAc4yClass);
		
	}
	
	public Ac4yIdentification(
			int aPersistentID
			,String aGUID
			,String aHumanId
			,String aPublicHumanId
			,String aTemplateGUID
			,String aTemplateHumanId
			,boolean aDeleted
			) {
		super(
			aPersistentID
			,aGUID
			,aHumanId
			,aPublicHumanId
			,aDeleted
		);
		
		setTemplate(new Ac4yClass());
		////getTemplate().setGUID(aTemplateGUID);
		getTemplate().setHumanId(aTemplateHumanId);

	}
	
	public Ac4yIdentification(
			int aPersistentID
			,String aGUID
			,String aHumanId
			,String aPublicHumanId
			,boolean aDeleted
			,Ac4yClass aTemplate
			) {
		
		super(
				aPersistentID
				,aGUID
				,aHumanId
				,aPublicHumanId
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