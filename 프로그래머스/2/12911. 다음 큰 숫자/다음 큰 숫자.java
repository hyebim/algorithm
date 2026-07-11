class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = n+1; ; i++) {
        	if(cntzero(n) == cntzero(i)) {
        		answer = i;
        		break;
        	}
        }
        return answer;
    }
    
    // 0 개수 반환 함수
	public int cntzero(int n) {
		int cnt = 0;
		String str = Integer.toBinaryString(n);
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '1') cnt++;
		}
		return cnt;
	}
}