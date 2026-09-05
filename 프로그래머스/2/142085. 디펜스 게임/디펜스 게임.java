import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        if(enemy.length == k) {
            return enemy.length;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        
        int i = 0;
        while(i < enemy.length && (k > 0 || n >= enemy[i])) {
            pq.offer(enemy[i]);
            n -= enemy[i]; // 남은 병사 수 
            
            if(n < 0 && k > 0) {
                n += pq.poll();
                k--;
            }
            i++;
        }
        
        answer = i;
        
        return answer;
    }
    
    
}