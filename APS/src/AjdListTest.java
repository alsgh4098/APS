import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AjdListTest {
	
	static class Node{
		int to;
		Node link;
		public Node(int to, Node link) {
			super();
			this.to = to;
			this.link = link;
		}
	}
	
	private static Node[] adjList;
	private static int N;
	private static boolean[] visited;
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점수
		int M = sc.nextInt(); // 간선수
		adjList = new Node[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		
//		dfs(1);
		bfs(1);
	}


	private static void dfs(int cur) {
		// TODO Auto-generated method stub
		visited[cur] = true;
		System.out.println((char)(cur+64));
		
		for (Node temp = adjList[cur]; temp != null; temp=temp.link) {
			if(!visited[temp.to]) {
				dfs(temp.to);
			}
		}
	}
	
	private static void bfs(int cur) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(cur);
		
		while(!q.isEmpty()) {
			int ths = q.poll();
			visited[cur] = true;
			System.out.print((char)(ths+64)+" ");
			
			for (Node temp = adjList[ths]; temp != null; temp=temp.link) {
				if(!visited[temp.to]) {
					q.offer(temp.to);
				}
			}
		}
		System.out.println();
	}
	
	

}
