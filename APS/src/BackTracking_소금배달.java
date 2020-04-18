import java.util.Scanner;

public class BackTracking_소금배달 {

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		gogosing2(M, 0);
//		System.out.println(min == Integer.MAX_VALUE ? -1:min);
	}// end of main
	
	// 한 깊이탐색마다 2제곱씩 탐색 경우의 수가 늘어난다.
	// 100단위 이상이면 속도가 안나고, 멈춘다.
	private static void gogosing(int M, int cnt) {
		if (M == 0) {
			if (cnt < min) {
				min = cnt;
			}
			return;
		} else if (M < 0) {
			return;
		} else {
			gogosing(M - 5, cnt + 1);
			gogosing(M - 3, cnt + 1);
		}
	}

	private static void gogosing2(int M, int cnt) {
		if (M < 0) {
			return;
		} else if (M == 0) {
			System.out.println(cnt == Integer.MAX_VALUE ? -1 : cnt);
			System.exit(0);
		} else {
			gogosing2(M - 5, cnt + 1);
			gogosing2(M - 3, cnt + 1);
		}
	}

}// end of class
