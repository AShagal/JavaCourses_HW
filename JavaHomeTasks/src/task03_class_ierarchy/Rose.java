package task03_class_ierarchy;

public class Rose extends Flower{
	private static final int ROSE_COST = 300;

	enum COLOR_ROSE {RED, YELLOW, PINK, WHITEPINK, WHITE, ORANGE};
	
	private COLOR_ROSE color;
	
	public Rose(COLOR_ROSE colorName, double length, FRESHNESS freshnessLevel) {
		this.setLength(length);
		this.setFreshnessLevel(freshnessLevel);
		this.setColor(colorName);
		this.setPrice(ROSE_COST);
	}

	public COLOR_ROSE getColor() {
		return color;
	}

	public void setColor(COLOR_ROSE color) {
		this.color = color;
	}
	
	
}