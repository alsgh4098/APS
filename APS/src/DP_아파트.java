import java.util.Scanner;

public class DP_아파트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		f(1) = 2
//		f(2) = 3
//		
//		dp : 이전차수와 관계식을 세우는 점화식.
		
		int[] dp = new int[101];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp[1] = 2;
		dp[2] = 5;
		
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i-1] +  dp[i-2];
		}
		
		System.out.println(dp[N]);
	}

}
