import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
        	q.offer(new int[] {priorities[i], i}); // 우선순위, index
        }

        int[] process = new int[priorities.length];
        int idx = 0;
        while(!q.isEmpty()) {
        	boolean isTrue = false;
        	int[] cur = q.poll();
        	for(int[] next : q) {
        		if(cur[0] < next[0]) { // 우선순위가 더 높은게 있으면
//        			q.offer(cur);
        			isTrue = true;
        			break;
        		} 
        	}
        	
        	if(isTrue) q.offer(cur);
        	else {
        		process[idx] = cur[1];
        		idx++;
        	}
        }
        
        for(int i = 0; i < process.length; i++) {
        	if(location==process[i]) answer = i+1;
        }
        return answer;
    }
}