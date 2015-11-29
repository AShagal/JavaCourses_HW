package task02_inheritance;

public class Specialization {

	static class Man {
		
		public void wakeUp() {
			System.out.println("waking up");
		}
		
	}

	static class EmployedMan extends Man{
		
		@Override
		public void wakeUp() {
			super.wakeUp();
			System.out.println("get ready for work");
			work();
		}
		
		public void work() {
			System.out.println("working");
		}
		
		public void haveABreak(int min) {
			System.out.println("will be back in " + min +" min");
		}
		
	}
	
}
