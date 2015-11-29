package task06_Comparable;

import java.util.Comparator;

public class Student {


	static class NameComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.name.compareTo(o2.name);
		}

	}

	static class MarkComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			if (o1.mark > o2.mark) {
				return 1;
			}
			else if(o1.mark < o2.mark) {
				return -1;
			}
			return 0;
		}

	}

	static class GroupComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.group - o2.group;
		}

	}

	public static final Comparator<Student> NAME_COMPARATOR = new NameComparator();
	public static final Comparator<Student> MARK_COMPARATOR = new MarkComparator();
	public static final Comparator<Student> GROUP_COMPARATOR = new GroupComparator();
	String name;
	double mark;
	int group;

	public Student(String name, double avMark, int groupId) {
		this.name = name;
		this.mark = avMark;
		this.group = groupId;
	}


	@Override
	public String toString() {
		return name + ":\t group #" + group + ", average point: " + mark;
	}

}
