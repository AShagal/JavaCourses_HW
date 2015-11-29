package task11_MyBoundedList;

public class UseMyBoundedList {

	public static void main(String[] args) {
		
		System.out.println("start");
		
		MyBoundedList<String> list = new MyBoundedList<>(3);
		
		try {
			list.remove(0);
		} catch (ListUnderflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			list.add("Hello");
			list.add("world");
			list.add("!");
			System.out.println(list.toString());
		} catch (ListOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			list.remove(1);
		} catch (ListUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.toString());

		try {
			list.remove(1);
		} catch (ListUnderflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(list.toString());

		try {
			list.add("!!!!");
		} catch (ListOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(list.toString());

		try {
			list.remove(0);
		} catch (ListUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.toString());
		System.out.println("finish");
	}
	
}
