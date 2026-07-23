class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        for(int h = 1; h <= citations.length; h++) {
        	int cnt = 0;
        	for(int i = 0; i < citations.length; i++) { 
        		if(citations[i] >= h) cnt++;
        		
        	}
        	if(cnt >= h) answer++;
        }
        return answer;
    }
}