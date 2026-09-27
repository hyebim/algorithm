import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }
        
        // 최대 힙(내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }
        
        int cnt = 0;
        while(!queue.isEmpty()) {     
            int[] cur = queue.peek();
                      
            if(pq.peek() == cur[0]) {
                queue.poll();
                pq.poll();              
                cnt++;            
                if(location == cur[1]) {
                    return cnt;
                }
            } else if(pq.peek() > cur[0]) {
                int[] back = queue.poll();
                queue.offer(new int[]{back[0], back[1]});
                // System.out.println(back[0] + " " + back[1]);
            }            

        }
        
        return answer;
    }
}