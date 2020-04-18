import java.util.Scanner;

public class Greedy_소금배달1{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int cnt = 0;
		
		while( M % 5 != 0) { // 5로 나누어 떨어지지 않는다면
			M -= 3;
			cnt++;
		}
		
		if(M < 0) { // 홀수
			System.out.println(-1);
		}else {
			cnt += M/5;
			System.out.println(cnt);
		}
	}// end of main

}// end of class
