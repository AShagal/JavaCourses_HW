package task15_BlockingQueue;

import java.util.Date;
import java.util.Random;


public class UseBlockingQueue {

	static Random random = new Random();

	static class Producer implements Runnable {

		private BlockingQueue<String> queue;

		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;

		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000 + random.nextInt(3000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				queue.put(new Date().toString());
				System.out.println("produced, total: " + queue.size());
			}
		}

	}

	static class Consumer implements Runnable {

		private BlockingQueue<String> queue;

		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(3000 + random.nextInt(3000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String item = queue.take();
				System.err.println(item + " consumed, total: " + queue.size());
			}
		}

	}

	public static void main(String[] args) {
		BlockingQueue<String> queue = new BlockingQueue<String>(5);
		
		new Thread(new Consumer(queue)).start();
		new Thread(new Producer(queue)).start();
	}

	
	
	
	
	
	
	
	
	
}
