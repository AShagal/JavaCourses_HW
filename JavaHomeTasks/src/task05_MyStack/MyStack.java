package task05_MyStack;

public class MyStack<T> {

	Node<T> top;


	public void push(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = top;
		top = node;
	}

	public Node<T> pop() {
		if (top != null) {
			Node<T> t = top;
			top = top.next;
			return t;
		}
		return null;
	}

	@Override
	public String toString() {

		String s = "[";

		Node temp = top;

		while (temp != null) {
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}

		return s + "]";
	}

}
