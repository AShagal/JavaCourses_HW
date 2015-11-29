package task08_MyListIterators;

import java.util.Iterator;

public class MyListStatic<T> implements Iterable<T>{

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
 
	static class MyIterator<T> implements Iterator<T> {

		MyListStatic<T> myList;
		Node<T> cur;

		public MyIterator(MyListStatic<T> list) {
			this.myList = list;
			cur = list.first;
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

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>(this);
	}
	
	public static void main(String[] args) {
		MyListStatic<String> list = new MyListStatic<String>() {
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
	}

}
