
import java.util.Arrays;
import java.util.Scanner;

public class DP_소금배달 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		dp : 이전차수와 관계식을 세우는 점화식.
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[3001];
//		1원 4원 6월
		
		Arrays.fill(dp, 999999);
		
		dp[3] = 1;
		dp[5] = 1;
		
		for (int i = 2; i <= 1000; i++) {
			dp[i*3] = dp[(i-1)*3]+1;
		}
		
		for (int i = 2; i <= 600; i++) {
			dp[i*5] = dp[(i-1)*5]+1;
		}
		
		for (int i = 8; i < 3000; i++) {
			if(dp[i-3] != 999999) {				
				dp[i] = Math.min(dp[i],dp[i-3] + 1);
			}
		}
		
		System.out.println(dp[N]==999999 ? -1:dp[N]);
	}

}
