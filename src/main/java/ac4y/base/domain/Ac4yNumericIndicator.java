package ac4y.base.domain;

public class Ac4yNumericIndicator {
	
	private int indicator = 0;

	public int getIndicator() {
		return indicator;
	}

	public void setIndicator(int indicator) {
		this.indicator = indicator;
	}
	
	public void increment() {
		indicator++;
	}
	
	public void decrement() {
		indicator--;
	}
	
	public void clear() {
		indicator = 0;
	}
	
	public void copy(Ac4yNumericIndicator aTarget) {
		aTarget.setIndicator(getIndicator());
	}
	
}
