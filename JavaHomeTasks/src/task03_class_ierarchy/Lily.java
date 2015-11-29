package task03_class_ierarchy;

public class Lily extends Flower{

	private static final int LILY_COST = 500;

	public Lily(double length, FRESHNESS freshnessLevel) {
		this.setLength(length);
		this.setFreshnessLevel(freshnessLevel);
		this.setPrice(LILY_COST);
	}
	
	
	
}
