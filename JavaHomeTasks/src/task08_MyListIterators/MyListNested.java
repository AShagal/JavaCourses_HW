package task08_MyListIterators;

import java.util.Iterator;


public class MyListNested<T> implements Iterable<T> {

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

	class MyIterator implements Iterator<T> {
		Node<T> cur = first;

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

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	public static void main(String[] args) {
		MyListNested<String> list = new MyListNested<String>() {
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
