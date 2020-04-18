
import java.util.Scanner;

public class DP_막대 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		dp : 이전차수와 관계식을 세우는 점화식.
		
		int[] dp = new int[101];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		System.out.println(dp[N]);

	}

}
