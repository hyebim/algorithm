import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int idx = 0;
        for(int i = 1; i < prices.length; i++) {
//        	if(prices[stack.peek()] < prices[i]) {
//        		answer[i-1] = 1;
//        	}
        	while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
        		idx = stack.pop();
            	answer[idx] = i - idx;
        	}
        	stack.push(i);
        	
        }
        System.out.println(stack);
        
        
        for(int i = 0; i < stack.size(); i++) {
        	int num = stack.get(i);
        	answer[num] = answer.length-num-1;
        	
        }
        return answer;
    }
}