import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < players.length; i++) {

            while(!queue.isEmpty() && queue.peek() == i) {
                int n = queue.poll();
                // System.out.println(n);
            }
            
            if(players[i] >= m && queue.size() < players[i] / m) {
                // System.out.println(i+k);
                while(queue.size() < players[i] / m) {
                    queue.offer(i+k);
                    answer++;
                }
            }
        
            
        }
        
        
        return answer;
    }
}