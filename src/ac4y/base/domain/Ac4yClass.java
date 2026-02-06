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
			int aPersistentID
			,String aGUID
			,String aHumanID
			,String aPublicHumanID
			) {
		super(aPersistentID, aGUID, aHumanID, aPublicHumanID);
	}

	public Ac4yClass(
			int aPersistentID
			,String aGUID
			,String aHumanID
			,String aPublicHumanID
			,boolean aDeleted
			) {
		super(aPersistentID, aGUID, aHumanID, aPublicHumanID, aDeleted);
	}
		
	public Ac4yClass(
			String aHumanID
			) {
		
		setHumanID(aHumanID);
		
	}

	public Ac4yClass(
			String aGUID
			,String aHumanID
			) {
		
		setGUID(aGUID);
		setHumanID(aHumanID);
		
	}
	
	
}