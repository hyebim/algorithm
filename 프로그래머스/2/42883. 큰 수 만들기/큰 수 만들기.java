import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        stack.push(number.charAt(0));
        for(int i = 1; i < number.length(); i++) {
            char ch = number.charAt(i);            
            
            while(!stack.isEmpty() && stack.peek() < ch && cnt < k) {
                stack.pop();
                cnt++;
            }
            
            stack.push(ch);
        }
        
        if(cnt == 0) {
            for(int i = 0; i < stack.size()-k; i++) {
                answer += stack.get(i);
            }
        } else {
            for(int i = 0; i < stack.size(); i++) {
                answer += stack.get(i);
            }
        }
        
        return answer;
    }
}