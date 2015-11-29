package task09_StackIterator;

import java.util.Iterator;

public class UseStack {

	public static void main(String[] args) {
		
		MyStack<String> stack = null;
		try {
			stack = new MyStack<String>(10) {
				{
					push("one");
					push("two");
					push("three");
				}
			};
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String item : stack) {
			System.out.println(item);
		}
		
		Iterator<String> it = stack.iterator();
		
		while (it.hasNext()) {
			String item = it.next();
			System.out.println(item);
		}
		
		Iterator<String> it1 = stack.iterator();
		System.out.println(it1.next());
		System.out.println(it1.next());
		
		Iterator<String> it2 = stack.iterator();

		System.out.println(it1.next());

		try {
			System.out.println("Stack empty = " + stack.isEmpty() + "; it's size = " + stack.size() + "; it's top = "
					+ stack.top());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stack.clear();
		System.out.println("Stack empty = " + stack.isEmpty() + "; it's size = " + stack.size());
	}
	
}
