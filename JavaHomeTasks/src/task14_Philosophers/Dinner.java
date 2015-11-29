package task14_Philosophers;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dinner {

	private static final int AMOUNT_PHILOSOPHERS = 5;
	private static final int AMOUNT_OBJECTS = 5;
	private static final int TIME_EATING = 1;
	private static final int TIME_SLEEPING = 2;
	private static final int TIME_DYING = 3;
	private static Object[] objects = new Object[AMOUNT_OBJECTS];
	

	static class Philosopher implements Runnable {
		private int idPhilosopher;
		static AtomicInteger token = new AtomicInteger(0);
		public Philosopher(int id) {
			this.idPhilosopher = id;
		}

		@Override
		public void run() {

			long start = System.nanoTime();
			long end = System.nanoTime();
			while (true) {
				end = System.nanoTime();
				if (((end - start) / 1_000_000) > TIME_DYING * 1000) {
					System.out.println("PHILOSOPHER #" + idPhilosopher + " IS DEAD!!!!!!!!!!!!!!!!!!!!!!!! \n"
							+ "TIME = " + ((end - start) / 1_000_000_000));
				}
				if (token.get() == idPhilosopher) {
					long startGenerate = System.nanoTime();
					try {
						synchronized (objects[idPhilosopher]) {
							System.out.println("Philosopher #" + idPhilosopher + " took left fork #" + idPhilosopher);
							synchronized (objects[(idPhilosopher + 1) % AMOUNT_OBJECTS]) {
								System.out.println("Philosopher #" + idPhilosopher + " took right fork #"
										+ ((idPhilosopher + 1) % AMOUNT_OBJECTS));
								System.out.println("Philosopher #" + idPhilosopher + " is eating");
								token.set((token.get() + 2) % AMOUNT_PHILOSOPHERS);
								Thread.currentThread().sleep(1000 * TIME_EATING);
								System.out.println("Philosopher #" + idPhilosopher + " end eating");
							}
						}
						start = System.nanoTime();
						System.out.println("Philosopher #" + idPhilosopher + " is snoozing");
						Thread.currentThread().sleep(1000 * TIME_SLEEPING);
						System.out.println("Philosopher #" + idPhilosopher + " end snoozing");
						end = System.nanoTime();
					} catch (Exception e) {
						// Catch the exception outside the loop.
						e.printStackTrace();
					}
				}

			}
		}
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[AMOUNT_PHILOSOPHERS];
		Lock lock = new ReentrantLock();

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Philosopher(i));
		}
		for (int i = 0; i < objects.length; i++) {
			objects[i] = new Object();
		}

		System.out.println("START DINNER");

		for (int j = 0; j < threads.length; j++) {
			threads[j].start();
		}
	  }
}
