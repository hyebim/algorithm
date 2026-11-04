import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { // 대기 큐
            if(a[2] == b[2]) {
                if(a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            } else {
                return Integer.compare(a[2], b[2]);
            }
        });
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        int time = 0;
        int idx = 0;
        int completed = 0;
        while(completed < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(new int[]{idx, jobs[idx][0], jobs[idx][1]});
                idx++;
            }
            
            if(pq.isEmpty()) {
                time++;
            } else {
                int[] cur = pq.poll();
                time += cur[2];
                answer += time-cur[1];
                completed++;
            }
        }
        

        return answer / jobs.length;
    }
}