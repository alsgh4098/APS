import java.util.Arrays;

public class 플로이드와샬 {

	public static void main(String[] args) {
		int N = 10;
		int M = 9;

		int[][] d = new int[N + 1][N + 1];
		
		for (int i = 0; i < d.length; i++) {
			Arrays.fill(d[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < M; i++) {
			// 간선 정보입력 
			// 거리 1로 둠.
		}
		
		// k가 거쳐가는 부분.
		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {

					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}

				}
			}
		}
		
		
	}

//	출처: https://mygumi.tistory.com/110 [마이구미의 HelloWorld]
}
