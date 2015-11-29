package task04_MyListUpdate;

public class MyList<T> {
	
	Node<T> first;
	Node<T> last;
	
	public void add(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;
		if (last != null) {
			last.next = node;
		} else {
			first = node;
		}
		last = node;
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
