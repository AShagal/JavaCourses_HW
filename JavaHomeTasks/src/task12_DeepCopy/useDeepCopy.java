package task12_DeepCopy;

import java.io.Serializable;

public class useDeepCopy {

	static class A {
		int x = 10;
	}

	static class B implements Serializable {
		String y = "123";
	}

	public static void main(String[] args) {
		A a = new A();
		A a1 = (A) Copy.deepCopy(a);
		A a2 = a;
		a.x = 12;

		System.out.println("A : obj:\t" + a.x);
		if (a1 != null) {
			System.out.println("A : deep copy:\t" + a1.x);
		}
		System.out.println("A : copy:\t" + a2.x);

		B b = new B();
		B b1 = (B) Copy.deepCopy(b);
		B b2 = b;
		b.y = "000";


		System.out.println("B : obj:\t" + b.y);
		if (b1 != null) {
			System.out.println("B : deep copy:\t" + b1.y);
		}
		System.out.println("B : copy:\t" + b2.y);
	}
}
