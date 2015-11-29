package task02_inheritance;

public class Variation {
	
	class Cat {
		String name;
		int age;
		
		public void play() {
			System.out.println("Playing.");
			meow();
		}
		
		private void meow() {
			System.out.println("Meow.");
		}

		public void sleep() {
			System.out.println("Sleeping.");
		}
		
		public void eat() {
			System.out.println("Eating.");
		}
	}
	
	class Dog extends Cat{
		@Override
		public void play() {
			System.out.println("Playing with ball.");
			bark();
		}

		private void bark() {
			System.out.println("Wow.");
		}
		
		
	}
}
