import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고리즘연습 {
	
	public static class Node implements Comparable<Node>{
		int idx;
		int dist;
		
		public Node(int idx, int dist) {
			super();
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			// 현재 연결된 간선중에서 거리(가중치)가 가장 가까운(작은) 노드부터 방문해야 하기 때문에
			if(this.dist > o.dist) {
				return 1;
			}else {
				return -1;
			}
		}
		
		
	}
	
	static List<Node>[] graph;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		
		for (int i = 1; i < V+1; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int ths = Integer.parseInt(st.nextToken());
			int tht = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			graph[ths].add(new Node(tht,dist));
			
		}
		
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		
		while(!pq.isEmpty()) {
			Node ths = pq.poll();
			
			if(visited[ths.idx]) {
				continue;
			}
			visited[ths.idx] = true;
			
			for (Node tht : graph[ths.idx]) {
				
				if(distance[tht.idx] > tht.dist) {
					distance[tht.idx] = tht.dist;
					pq.add(new Node(tht.idx,distance[tht.idx]));
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < distance.length; i++) {
			sb.append(distance[i]==Integer.MAX_VALUE?"INF\n":distance[i]+"\n");
		}
		
		System.out.println(sb);
		
		
	}

}
