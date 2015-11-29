package task03_class_ierarchy;

import java.util.ArrayList;
import java.util.Collections;

public class Bouquet {

	private ArrayList<Flower> bouquet = new ArrayList<Flower>();
	private int price = 0;
	
	public void addFlower(Flower flower) {
		bouquet.add(flower);
		price += flower.getPrice();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	ArrayList<Flower> sortByFreshness(){
		ArrayList<Flower> sortedBouquet = bouquet;
		Collections.sort(sortedBouquet);
		return sortedBouquet;
	}
	
	Flower findFlower(double lowBordLength, double upBordLength) {
		Flower foundFlower = null;
		
		for (Flower flower : bouquet) {
			if(flower.getLength() < upBordLength && flower.getLength() > lowBordLength) {
				foundFlower = flower;
				break;
			}
		}
		
		return foundFlower;
		
	}
	
	
	
}
