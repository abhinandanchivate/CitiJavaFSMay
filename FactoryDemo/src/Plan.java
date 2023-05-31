
public abstract class Plan {
	// we can't create an object of abstrac class.
	
	protected double rate;
	abstract void getRate();
	public void calculateBill(int units) {
		System.out.println(rate* units);
	}

}
