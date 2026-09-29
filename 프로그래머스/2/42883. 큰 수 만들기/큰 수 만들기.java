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

        for(int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        
        if(stack.size() == number.length()) {
            for(int i = number.length()-1; i >= 0; i--) {
                sb.deleteCharAt(i);
                cnt++;
                if(cnt == k) {
                    return sb.toString();
                }
            }
        }
        
        return sb.toString();
    }
}