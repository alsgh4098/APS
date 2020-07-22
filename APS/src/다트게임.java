
public class 다트게임 {

	public static void main(String[] args) {
		System.out.println(solution("1D2S#10S"));
	}
	
    public static int solution(String dartResult) {
        int answer = 0;
        
        int[] score = new int[3];
        
        // idx는 [ 점수,보너스 ] [ 점수,보너스,옵션 ]으로 끝나는 경우에 늘려준다.
        int idx = 0;
        
        for (int i = 0; i < dartResult.length(); i++) {
        	char c = dartResult.charAt(i);
        	
        	if(0<= c-'0' && c-'0' <= 10) {
        		// 10이 나올경우
        		if( c == '1' && dartResult.charAt(i+1) == '0') {
        			score[idx] = 10;
        			i++;
        		}else {
        			score[idx] = c-'0';
        		}
        	}else {
        		switch (c) {
					case 'S':
						//뒤에 옵션이 존재하지 않는 경우 한 idx를 늘림으로써 하나의 단위로 분리시킨다.
						if(i+1<dartResult.length()) {
							if(0<= dartResult.charAt(i+1) -'0'
							  && dartResult.charAt(i+1) -'0' <= 10) {
								idx++;
							}
						}
						break;
					case 'D':
						score[idx] *= score[idx];
						if(i+1<dartResult.length()) {
							if(0<= dartResult.charAt(i+1) -'0'
							  && dartResult.charAt(i+1) -'0' <= 10) {
								idx++;
							}
						}
						break;
					case 'T':
						score[idx] *= score[idx] * score[idx];
						if(i+1<dartResult.length()) {
							if(0<= dartResult.charAt(i+1) -'0'
							  && dartResult.charAt(i+1) -'0' <= 10) {
								idx++;
							}
						}
						break;
					case '*':
						score[idx] *= 2;
						
						// 이전 값이 존재하는경우 그 값도 *2
						if(idx-1>=0) {
							score[idx-1] *= 2;
						}
						idx++;
						break;
					case '#':
						// 현재 값에 -1
						score[idx] *= -1;
						idx++;
						break;
					default:
						break;
				}
        	}

		}
        
        for (int i = 0; i < score.length; i++) {
        	answer += score[i];
		}
        
        return answer;
    }

}
