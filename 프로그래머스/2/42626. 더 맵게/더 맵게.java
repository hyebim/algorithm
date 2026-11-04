import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville) {
            pq.offer(scov);
        }
        
        if(pq.peek() >= K) {
            return 0;
        }
        
        while(!pq.isEmpty() && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second * 2;
            pq.offer(sum);      
            answer++;
            
            if(answer == scoville.length-1 && pq.peek() < K) {
                return -1;
            }
        }
        
        return answer;
    }
}