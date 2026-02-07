package ac4y.base.domain;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Ac4yClass extends Ac4yIdentificationCommon {

	public Ac4yClass() {
		initGUID();
	}
	
	public Ac4yClass(
			int aPersistentId
			,String aGUID
			,String aHumanId
			,String aPublicHumanId
			) {
		super(aPersistentId, aGUID, aHumanId, aPublicHumanId);
	}

	public Ac4yClass(
			int aPersistentId
			,String aGUID
			,String aHumanId
			,String aPublicHumanId
			,boolean aDeleted
			) {
		super(aPersistentId, aGUID, aHumanId, aPublicHumanId, aDeleted);
	}
		
	public Ac4yClass(
			String aHumanId
			) {
		
		setHumanId(aHumanId);
		
	}

	public Ac4yClass(
			String aGUID
			,String aHumanId
			) {
		
		setGUID(aGUID);
		setHumanId(aHumanId);
		
	}
	
	
}