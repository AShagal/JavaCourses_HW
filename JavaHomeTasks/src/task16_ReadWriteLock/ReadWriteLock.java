package task16_ReadWriteLock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
	private Lock writeLock = new ReentrantLock();
	private Lock readLock = new ReentrantLock();

	static List<String> list = new LinkedList<>();

	public void readList(String str) {
		writeLock.lock();
		try {
			for (String object : list) {
				if (str.equals(object)) {
					System.out.println("found string " + str);
					Thread.currentThread().sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}

	public void writeList(String str) {
		readLock.lock();
		writeLock.lock();

		try {
			list.add(str);
			System.out.println("Adding string " + str);
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
			writeLock.unlock();
		}
	}

	public static void main(String[] args) {
		ReadWriteLock rwLock = new ReadWriteLock();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					rwLock.writeList("hello");
					rwLock.writeList("world");
					try {
						Thread.currentThread().sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					rwLock.readList("world");
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

}
