import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라_Main_1753_최단경로_gold5 {
	
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
		// 출발점으로부터의 거리를 입력받을 배열
		int[] distance = new int[V+1];
		// 초기값은 최대값으로 초기화
		Arrays.fill(distance, Integer.MAX_VALUE);
		// 시작점은 0.
		distance[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start,distance[start]));
		
		while(!pq.isEmpty()) {
			Node ths = pq.poll();
			
			if(visited[ths.idx]) {
				continue;
			}
			visited[ths.idx] = true;
			
			// 현재 노드에 연결된 노드들.
			for (Node tht : graph[ths.idx]) {
				// 연결된 노드와 시작점의 거리가 이 지점 까지 오는데 걸린 거리보다 클 경우 값을 바꿔준다.
				if(distance[tht.idx] > tht.dist+distance[ths.idx]) {
					distance[tht.idx] = tht.dist+distance[ths.idx];
					// 주의할 점, 바뀐 거리값을 넣어줘야 한다.
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
