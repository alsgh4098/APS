import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {
	static class Student implements Comparable<Student>{
		int no, s;

		public Student(int no, int s) {
			super();
			this.no = no;
			this.s = s;
		}
		
		public int compareTo(Student o) {
			// 오름차순 정리
			return this.no - o.no;
		}

		@Override
		public String toString() {
			return "Student [no=" + no + ", s=" + s + "]";
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students = new Student[] {
				new Student(1,100),
				new Student(10,50),
				new Student(5,10)
		};
		
		// comparator없이 하면 java.lang.ClassCastException
		Arrays.sort(students);
		
		System.out.println(Arrays.toString(students));
		
		Arrays.sort(students,new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.s - o2.s;
			}
		});
		
		System.out.println(Arrays.toString(students));
		
	}

}
