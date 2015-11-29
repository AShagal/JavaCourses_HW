package task02_inheritance;

public class Specification {

	public static abstract class Flower {
		public abstract void bloom();
		public abstract void water();
	}
	
	
	public static class ForgetMeNot extends Flower {
		
		private int timesWatered = 0;
		
		@Override
		public void bloom() {
			if(timesWatered > 5) {				
				System.out.println("Forget-me-not blooming.");	
			}
			else {
				System.out.println("Not enough water for forget-me-not.");
			}
		}

		@Override
		public void water() {
			timesWatered++;
			System.out.println("Watering forget-me-not " + timesWatered + " time.");
		}
		
	}
	
}
