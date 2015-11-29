package task03_class_ierarchy;

public class Flower implements Comparable<Flower>{
	enum FRESHNESS{BEST, GOOD, NORMAL, BAD, WORST};

	private FRESHNESS freshnessLevel;
	private double length;
	private int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public FRESHNESS getFreshnessLevel() {
		return freshnessLevel;
	}
	public void setFreshnessLevel(FRESHNESS freshnessLevel) {
		this.freshnessLevel = freshnessLevel;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	@Override
	public int compareTo(Flower flower) {
		return getFreshnessLevel().compareTo(flower.getFreshnessLevel());
	}
	
}

