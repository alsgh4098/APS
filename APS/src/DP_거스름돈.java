
import java.util.Scanner;

public class DP_거스름돈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		dp : 이전차수와 관계식을 세우는 점화식.
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[101];
//		1원 4원 6월
		
		dp[0] = 0;
		
		for (int i = 1; i < 4; i++) {
			dp[i] = dp[i-1]+1;
		}
		
		for (int i = 4; i < 6; i++) {
			dp[i] = Math.min(dp[i-1]+1,dp[i-4]+1);
		}
		
		for (int i = 6; i <= 100; i++) {
			dp[i] = Math.min(dp[i-1]+1,dp[i-4]+1);
			dp[i] = Math.min(dp[i], dp[i-6]+1);
		}
		
		System.out.println(dp[N]);
	}

}
