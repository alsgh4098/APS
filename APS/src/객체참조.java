import java.util.ArrayList;

public class 객체참조 {
	
	static class Node{
		int x;
		int y;
		int size;
		
		public Node(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", size=" + size + "]";
		}
		
	}

	public static void main(String[] args) {
		ArrayList<Node> list = new ArrayList<Node>();
		
		list.add(new Node(1,2,3));
		System.out.println(list.get(0).toString());
		list.get(0).size = 100000;
		System.out.println(list.get(0).toString());
	}

}
