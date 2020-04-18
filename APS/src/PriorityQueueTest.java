import java.util.PriorityQueue;

public class PriorityQueueTest {
	static class Student implements Comparable<Student>{
		int no, s;

		public Student(int no, int s) {
			super();
			this.no = no;
			this.s = s;
		}
		
		public int compareTo(Student o) {
			// 오름차순 정리
			// 양수면 바꾼다.
			return this.no - o.no;
		}

		@Override
		public String toString() {
			return "Student [no=" + no + ", s=" + s + "]";
		}
		
		
	}
	public static void main(String[] args) {
		PriorityQueue<Student> queue = new PriorityQueue<Student>();
		
//		PriorityQueue<Student> queue = new PriorityQueue<Student>(new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.s - o2.s;
//			}
//		});
		
		queue.offer(new Student(10,100));
		queue.offer(new Student(1,80));
		queue.offer(new Student(5,50));
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}
