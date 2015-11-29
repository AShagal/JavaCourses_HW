package task02_inheritance;

public class Restriction {

	class Dog {
		String name;
		int age;
		
		public void guard() {
			System.out.println("Guarding.");
		}
	
		public void play() {
			System.out.println("Playing");
			sleep();
		}
		
		public void sleep() {
			System.out.println("Sleeping.");
		}

		public void feed() {
			System.out.println("Eating.");
		}
	}
	
	class Puppy extends Dog {
		@Override
		public void play() {
			System.out.println("Playing with ball.");
			System.out.println("Playing with stick.");
			System.out.println("Playing with tail1.");
		}
		
		@Override
		public void guard() {
			throw new UnsupportedOperationException();
		}
	}
	
}
