package ac4y.base.domain;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Ac4yLightIndicator {
	
		private boolean light = false;

		public boolean isLight() {
			return light;
		}

		public void setLight(boolean light) {
			this.light = light;
		}

		public void on() {
			setLight(true);
		}

		public void off() {
			setLight(false);
		}

		public boolean yes() {
			return light;
		}

		public boolean no() {
			return !light;
		}
}
