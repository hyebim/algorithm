import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> wait = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++) {
        	wait.offer(truck_weights[i]);
        }
        
        int time = 0;
        Queue<int[]> on = new LinkedList<>();
        int sum = 0;
        while(!wait.isEmpty() || !on.isEmpty()) {
        	time++;
        	
        	if(!on.isEmpty() && time-on.peek()[1] == bridge_length) {
        		sum -= on.peek()[0];
        		on.poll();
        	}
        	
        	if(!wait.isEmpty() && on.size() < bridge_length && sum+wait.peek() <= weight) {
        		sum += wait.peek();
        		on.offer(new int[] {wait.poll(), time});
        	}
        }
        
        answer = time;
        return answer;
    }
}