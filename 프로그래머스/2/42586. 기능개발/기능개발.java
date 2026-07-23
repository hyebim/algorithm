import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        for(int i = 0; i < progresses.length; i++) {
        	if((100 - progresses[i])%speeds[i]==0) {
        		progresses[i] = (100 - progresses[i])/speeds[i];
        	} else {
        		progresses[i] = (100 - progresses[i])/speeds[i]+1;
        	}
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(progresses[0]);
        int max = progresses[0];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < progresses.length; i++) {
        	int size = stack.size();
        	if(stack.get(0)>=progresses[i]) {
        		max = Math.max(max, progresses[i]);
        		stack.push(progresses[i]);
        		
        	} else {
        		int cnt = 0;
        		while(cnt < size) {
        			stack.pop();
        			cnt++;
        		}
        		stack.push(progresses[i]);
        		list.add(cnt);
//        		System.out.println(cnt);
        	}
        	
        }
        
        list.add(stack.size());
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}