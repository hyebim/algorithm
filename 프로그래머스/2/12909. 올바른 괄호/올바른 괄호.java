import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        // 처음에 먼저 스택을 채워
        if(s.charAt(0) == '(') {
    		stack.push(s.charAt(0));
    	} else answer = false;
        
        for(int i = 1; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		
        	if(ch == '(') {
        		stack.push(ch);
        	} else if(ch == ')') {
        		if(!stack.isEmpty()&&stack.peek() == '(') {
        			stack.pop();
        		}
        	}
        	
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}