package task09_StackIterator;

import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {

	T[] data;
	private int next;

	public MyStack(int maxSize) {
		if (maxSize <= 0) {
			throw new IllegalArgumentException();
		}
		data = (T[]) new Object[maxSize];
	}

	public T top() throws StackUnderflowException {
		if (next == 0) {
			throw new StackUnderflowException();
		}
		return data[next - 1];
	}

	public int size() {
		return next;
	}

	public boolean isEmpty() {
		return next == 0;
	}

	public void clear() {
		while (next != 0) {
			data[--next] = null;
		}
	}

	public void push(T item) throws StackOverflowException {
		if (next == data.length) {
			throw new StackOverflowException("Overflow: max size = "
					+ data.length);
		}
		data[next++] = item;
	}

	public T pop() throws StackUnderflowException {
		if (next == 0) {
			throw new StackUnderflowException();
		}
		T tmp = data[--next];
		data[next] = null;
		return tmp;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int currentNext = 0;

			@Override
			public boolean hasNext() {
				return currentNext != next;
			}

			@Override
			public T next() {
				T item = data[currentNext];
				currentNext += 1;
				return item;
			}

			@Override
			public void remove() {
			}

		};
	}

}
