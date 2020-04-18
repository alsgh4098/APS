import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main_1863_종교_Union_Find {
	
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		rank = new int[n+1];
		
		for (int i = 1; i < n+1; i++) {
			parent[i] = i;
		}
		
		for (int t = 1; t <= m; t++) {
			 st = new StringTokenizer(br.readLine());
				
			int stu1 = Integer.parseInt(st.nextToken());
				
			int stu2 = Integer.parseInt(st.nextToken());
			
			union(stu1,stu2);
			
			
		}
		
		int count = 0;
		
		for (int i = 1; i < n+1; i++) {
			if( parent[i] == i) {
				count++;
			}
		}
		
		System.out.println(count);

	}
	//parent[val] 에는 val의 parent가 담겨있다.
	static int find_root(int val) {
		if(parent[val] == val) {
			return val;
		}else {
			return parent[val] = find_root(parent[val]);
		}
	}
	
	static void union(int s1, int s2) {
		int r1 = find_root(s1);
		int r2 = find_root(s2);
		
		if(rank[r1] < rank[r2]) {
			parent[r1] = r2;
		}else {
			
			parent[r2] = r1;
			
			if(rank[r1] == rank[r2]) {
				rank[r1]++;
			}
		}
	}

}
