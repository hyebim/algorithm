import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]}); //인덱스, 우선순위로 큐에 넣기
        }
        
        int[][] p = new int[priorities.length][2];
        for(int i = 0; i < priorities.length; i++) {
            p[i][0] = i;
            p[i][1] = priorities[i];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1])); 
        for(int i = 0; i < priorities.length; i++) {
            pq.offer(p[i]);
        }
     
        int order = 0;
        while(!queue.isEmpty()) {
            if(pq.peek()[1] == queue.peek()[1]) {
                order++;
                pq.poll();
                int[] cur = queue.poll();
                if(location == cur[0]) {       
                    return order; 
                }
            } else {
                queue.offer(queue.poll());
            }            
        }
       
        return answer;
    }
}