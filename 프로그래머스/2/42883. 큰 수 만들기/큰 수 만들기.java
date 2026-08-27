import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int[] num = new int[number.length()];
        for(int i = 0; i < number.length(); i++) {
        	num[i] = number.charAt(i)-'0';
        }
        
        int j = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(num[0]);
        
        int cnt = 0;
        while(!stack.isEmpty() && j < num.length) {
        	while(!stack.isEmpty() && stack.peek() < num[j] && cnt < k) {
    			stack.pop();
        		cnt++;
    		}
        	stack.push(num[j]);
        	j++;
        }
        
        if(cnt == 0) {
        	while(cnt < k) {
        		stack.pop();
        		cnt++;
        	}
        }
        
        for(int i = 0; i < stack.size(); i++) {
        	answer += stack.get(i);
        }
        return answer;
    }
}
