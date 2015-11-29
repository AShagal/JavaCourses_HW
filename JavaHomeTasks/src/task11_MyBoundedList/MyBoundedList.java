package task11_MyBoundedList;

public class MyBoundedList<T> {

	private class Node {
		T data;
		Node next;
	}

	private Node first;
	private Node last;
	private int currentSize = 0;
	private int maxSize;

	public MyBoundedList(int maxSize) {
		if (maxSize <= 0) {
			throw new IllegalArgumentException();
		}
		this.maxSize = maxSize;
	}

	public void add(T data) throws ListOverflowException {
		if(currentSize == maxSize) {
			throw new ListOverflowException("Can't add " + (currentSize + 1) + "'s element. Maximum size is " + maxSize + ".");
		}
		Node node = new Node();
		node.data = data;
		node.next = null;
		if (last != null) {
			last.next = node;
		} else {
			first = node;
		}
		currentSize++;
		last = node;
	}

	public void remove(int ind) throws ListUnderflowException {
		if (ind < 0 || ind >= currentSize) {
			throw new ListUnderflowException("Can't delete item #" + ind + ". There are " + currentSize + " elements in list.");
		}
		currentSize--;
		Node iter = first;
		if (ind == 0) {
			first = iter.next;
			iter.data = null;
			return;
		}
		int pos = 0;
		while (pos != ind - 1) {
			iter = iter.next;
		}
		Node rem = iter.next;
		iter.next = rem.next;
		rem.data = null;
		if (ind == currentSize - 1) {
			last = iter;
		}
	}

	@Override
	public String toString() {
		String s = "[";

		Node temp = first;

		while (temp != null) {
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}

		return s + "]";
	}

}
