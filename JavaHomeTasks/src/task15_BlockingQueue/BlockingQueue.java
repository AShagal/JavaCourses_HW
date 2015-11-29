package task15_BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
	
	private Queue<T> queue = new LinkedList<>();
	
	int maxSize;

	public BlockingQueue(int maxSize) {
		this.maxSize = maxSize;
	}

	public T take() {
		synchronized (queue) {
			while (queue.isEmpty()) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			queue.notify();
			return queue.poll();
		}
	}

	public void put(T item) {
		synchronized (queue) {
			while (queue.size() == maxSize) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			queue.offer(item);
			queue.notify();
		}
	}

	public int size() {
		return queue.size();
	}
	
	
	
	
	
	
	
	
	
	
	
}
