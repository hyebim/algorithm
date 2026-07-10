import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int length = s.length();
        while(length != 1) {
        	answer[1] += cntzero(s);
        	length = s.length()-cntzero(s);
        	s = Integer.toBinaryString(length);
        	cnt++;
        }
        answer[0] = cnt;
        return answer;
    }
    
    public int cntzero(String s) {
		int cnt = 0; // 제거된 0의 개수
		
		for(int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if(ch == '0') { // 0개수 세기
        		cnt++;
        	}
        }
		return cnt;
	}
}