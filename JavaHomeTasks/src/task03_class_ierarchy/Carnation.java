package task03_class_ierarchy;

public class Carnation extends Flower{
	private static final int CARNATION_COST = 80;

	enum COLOR_CARNATION {PINK, WHITE, RED};
	
	private COLOR_CARNATION color;
	
	public Carnation(COLOR_CARNATION colorName, double length, FRESHNESS freshnessLevel) {
		this.setColor(colorName);
		this.setLength(length);
		this.setFreshnessLevel(freshnessLevel);
		this.setPrice(CARNATION_COST);
	}

	public COLOR_CARNATION getColor() {
		return color;
	}

	public void setColor(COLOR_CARNATION color) {
		this.color = color;
	}
	
}
