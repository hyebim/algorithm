import java.util.*;
class Solution {
    public String solution(String number, int k) {
        
        Stack<Character> stack = new Stack<>();
        char[] ch = number.toCharArray();
        stack.push(ch[0]);
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < number.length(); i++) {
            while(!stack.isEmpty() && cnt < k && (stack.peek()-'0') < (ch[i]-'0')) {
                stack.pop();
                cnt++;
            }
            stack.push(ch[i]);
        }

        while(cnt < k) {
            stack.pop();
            cnt++;
        }
        
        for(int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
    
        
        return sb.toString();
    }
}