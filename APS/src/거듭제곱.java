
public class 거듭제곱 {
	
//	시간 복잡도 log(N)
//	https://mygumi.tistory.com/319

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(2,10));
		System.out.println(pow2(2,10));
	}
	
	public static long pow(int number, int n) {
		if( n == 0) {
			return  1;
		}
		
		long res = pow(number, n/2);
		long temp = res*res;
		
		
		if( n % 2 == 0) {
			return temp;
		}else {
			return temp*number;
		}
	}
	
	public static long pow2(int number, int n) {
		if(n==0) {
			return 1;
		}else if( n%2 == 0) {
			long res = pow2(number,n/2);
			long temp = res*res;
			return temp;
		}else {
			long res = pow2(number,(n-1)/2);
			long temp = res*res*number;
			return temp;
		}
	}

}
