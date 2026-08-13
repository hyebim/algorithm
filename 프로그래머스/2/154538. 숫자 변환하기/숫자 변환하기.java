import java.util.*;
class Solution {
    static int[] visit;
    public static int solution(int x, int y, int n) {
    	int answer = 0;
//    	visit = new int[y+1];
//    	Arrays.fill(visit, Integer.MAX_VALUE);
//    	
//        DFS(x, y, n, 0);
//        if(visit[x] == Integer.MAX_VALUE) {
//        	answer = -1;
//        } else {
//        	answer = visit[x];
//        }
    	
    	answer = BFS(x, y, n);
        
        return answer;
    }
    
    public static int BFS(int x, int y, int n) {
    	Queue<Integer> q = new LinkedList<>();
    	visit = new int[y+1];
    	Arrays.fill(visit, -1);
    	
    	visit[x] = 0;
    	q.offer(x);
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		int[] nexts = {cur+n, cur*2, cur*3};
    		
    		for(int i = 0; i < 3; i++) {
    			int next = nexts[i];
    			
    			if(next == y) {
    				return visit[cur] + 1;
    			}
    			
    			if (next > y) {
    			    continue;
    			}
    			
    			if(visit[next] == -1) {
    				visit[next] = visit[cur] + 1;
        			q.offer(next);
    			}
    		}
    	}
    	return visit[y];
    }
}