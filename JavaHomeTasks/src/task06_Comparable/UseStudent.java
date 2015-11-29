package task06_Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseStudent {

	public static void main(String[] args) {
		List<Student> univercity = new ArrayList<>();
		
		univercity.add(new Student("Anna", 5, 110));
		univercity.add(new Student("Mark", 5, 111));
		univercity.add(new Student("Pete", 3.7, 100));
		univercity.add(new Student("George", 2.9, 111));
		univercity.add(new Student("David", 4.1, 111));
		univercity.add(new Student("Kate", 4.7, 111));
		univercity.add(new Student("Jack", 3.2, 110));
		univercity.add(new Student("John", 4.5, 110));
		univercity.add(new Student("Maria", 4.8, 100));

		Collections.sort(univercity, Student.NAME_COMPARATOR);
		System.out.println("Sorted by student's name:");
		for (Student student : univercity) {
			System.out.println(student);
		}
		Collections.sort(univercity, Student.GROUP_COMPARATOR);
		System.out.println("\nSorted by student's group:");
		for (Student student : univercity) {
			System.out.println(student);
		}
		Collections.sort(univercity, Student.MARK_COMPARATOR);
		System.out.println("\nSorted by student's mark:");
		for (Student student : univercity) {
			System.out.println(student);
		}
	}

}
