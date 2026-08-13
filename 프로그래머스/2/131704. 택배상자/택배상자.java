import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        int i = 0;
        while(num <= order.length) {
        	if(order[i] > num) {
        		stack.push(num);
        		num++;
        	} else if(order[i] == num) {
        		answer++;
        		i++;
        		num++;
        		while (!stack.isEmpty() && stack.peek() == order[i]) {
            		stack.pop();
            		answer++;
            		i++;
            	} 
        	} else {
        		break;
        	}
        }
        return answer;
    }
}