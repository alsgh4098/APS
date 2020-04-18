
public class KMP {

	// 모든 경우를 다 비교하지 않아도 부분 문자열을 찾을 수 있는 알고리즘
	// 접두사와 접미사의 개념을 활용해서, '반복되는 연산을 최대한 줄이도록'
	// 지금까지 검사한 문자열의 접두사와 접미사가 일치하는 최대길이 만큼 겹침을 이용

	// 파이테이플 : 각 길이별로 접두사 == 접미사의 최대길이가 저장된 배열

	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];

		char[] pttrn = pattern.toCharArray();
		pi = new int[pttrn.length];

		int j = 0;
		
		for (int i = 1; i < pttrn.length; i++) {
			while(j>0 && pttrn[i] != pttrn[j]) {
				j = pi[j-1];
			}
			
			if(pttrn[i] == pttrn[j]) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}

	static int KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		char[] pttrn = pattern.toCharArray();
		char[] orgn = origin.toCharArray();
		
		int j = 0;

		for (int i = 0; i < orgn.length; i++) {
			while( j>0 && orgn[i] != pttrn[j]) {
				j = pi[j-1];
			}
			
			if(orgn[i] == pttrn[j]) {
				if( j == pttrn.length-1) {
					j = pi[j];
					cnt++;
					return i-pttrn.length+2;
				}else {
					++j;
				}
			}
		}

		return -1;
	}
	
	static int cnt;
	
	public static void main(String[] args) {
		String origin = "HELLOSSAFY";
		String pattern = "LOSS";
		System.out.println(KMP(origin, pattern));
		System.out.println(cnt);
	}
}