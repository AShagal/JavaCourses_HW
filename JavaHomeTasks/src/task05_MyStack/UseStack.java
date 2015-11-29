package task05_MyStack;

public class UseStack {

	public static void main(String[] args) {
	
		MyStack<String> stack = new MyStack<>();
		
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
//		list.add(10); ERROR!
		
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}
	
}
