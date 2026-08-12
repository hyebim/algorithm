import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
        	pq.offer(scoville[i]);
        }
        
        if(pq.peek() >= K) return 0;
        else {
        	int rank1 = 0;
            int rank2 = 0;
            int sum = 0;
            while(pq.peek() < K) {
            	rank1 = pq.poll();
            	rank2 = pq.poll();
            	
            	if(rank1 < K || rank2 < K) {
            		sum = rank1 + rank2 * 2;
            		pq.offer(sum);
                	answer++;
            	}
            	
            	if(pq.peek() < K && pq.size() == 1) return -1;
            }
            
            if(answer == 0) return -1;
        }
        return answer;
    }
}