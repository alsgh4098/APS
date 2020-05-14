import java.util.Arrays;

public class 순열과조합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static char[] chars = { 'a', 'b', 'c', 'd' };
	static int N = 5;
	static int R = 3;
	static int[] nums;
	static int[] cc = { -1, -3, 4, -5, 6 };
	static int max = Integer.MIN_VALUE;

	static void makePermutatino(int r, char[] temp, boolean[] visited) {
		// base rule
		if (r == 0) {
			// 솔루션 실행
			System.out.println(Arrays.toString(temp));
			return;
		}
		// inductive rule
		for (int i = 0; i < chars.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[r - 1] = chars[i];
				makePermutatino(r - 1, temp, visited);
				visited[i] = false;
			}
		}

	}

	public static void combi(int start, int count) {
		if (count == R) {
			int tmp = 1;
			for (int i = 0; i < nums.length; i++) {
				tmp *= nums[i];
			}
			if (tmp > max) {
				max = tmp;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			nums[count] = cc[i];
			combi(i + 1, count + 1);
		}
	}

	static void combi2(int start, int cnt) {
		if (cnt == R) {

			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[cnt] = i;
			combi2(i+1,cnt+1);
		}
	}
	
	static void permu(int cnt, boolean[] visited) {
		if(cnt == R) {
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i] == true) {
				nums[i] = i;
				visited[i] = true;
				permu(cnt+1, visited);
				visited[i] = false;
			}
		}
	}
}
