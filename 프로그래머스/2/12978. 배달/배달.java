import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new int[]{road[i][1], road[i][2]});
            graph.get(road[i][1]).add(new int[]{road[i][0], road[i][2]});
        } 
        
        int[] distance = dijkstra(N, graph);
        for(int i = 0; i < N+1; i++) {
            if(distance[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
    
    public int[] dijkstra(int N, ArrayList<ArrayList<int[]>> graph) {
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        // 0: 누적시간, 1: 마을번호
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        
        pq.offer(new int[]{0, 1});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curTime = cur[0];
            int curNum = cur[1];

            if(distance[curNum] != curTime) {
                continue;
            }
            
            for(int[] next : graph.get(curNum)) {
                int nextNum = next[0];
                int time = next[1];
                
                int nextTime = curTime + time;
                
                if(distance[nextNum] > nextTime) {
                    distance[nextNum] = nextTime;
                    pq.offer(new int[]{nextTime, nextNum});
                }
            }
        }
        
        return distance;
    }
}
