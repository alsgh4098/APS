import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.isEmpty() +"//" + queue.size());
		queue.offer("진민호");
		queue.offer("박진원");
		queue.offer("김대우");
		System.out.println(queue.isEmpty() +"//" + queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty() +"//" + queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty() +"//" + queue.size());
		
//		queue.po

	}

}
