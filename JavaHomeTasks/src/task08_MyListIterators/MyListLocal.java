package task08_MyListIterators;

import java.util.Iterator;

class MyIterator<T> implements Iterator<T> {
	Node<T> cur;

	public MyIterator(Node<T> node) {
		cur = node;
	}

	@Override
	public boolean hasNext() {
		return cur != null;
	}

	@Override
	public T next() {
		T data = cur.data;
		cur = cur.next;
		return data;
	}

}

public class MyListLocal<T> implements Iterable<T> {

	Node<T> first;

	public void add(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = first;
		first = node;
	}

	@Override
	public String toString() {

		String s = "[";

		Node<T> temp = first;

		while (temp != null) {
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}

		return s + "]";
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(first);
	}

	public static void main(String[] args) {
		MyListLocal<String> list = new MyListLocal<String>() {
			{
				add("one");
				add("two");
				add("three");
			}
		};

		for (String item : list) {
			System.out.println(item);
		}

		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			String item = it.next();
			System.out.println(item);
		}

		Iterator<String> it1 = list.iterator();
		System.out.println(it1.next());
		System.out.println(it1.next());
		System.out.println(it1.next());
	}

}
