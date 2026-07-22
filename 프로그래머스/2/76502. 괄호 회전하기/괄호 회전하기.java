import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i = 0; i < s.length(); i++) { // 문자열 길이만큼 반복
        	char ch = sb.charAt(0);
        	sb.deleteCharAt(0);
        	sb.append(ch);
//        	System.out.println(sb.toString());
        	
        	// 여기서 스택 검사하고
//        	System.out.println(func(sb.toString()));
        	if(func(sb.toString())==1) answer++;
        }
       
        return answer;
    }
    
    public int func(String s) {
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		
		if(s.charAt(0)==')'||s.charAt(0)=='}'||s.charAt(0)==']') {
			return cnt;
		} else stack.push(s.charAt(0));
		
		int i = 1;
		while(i < s.length()) {
			if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[') {
				stack.push(s.charAt(i));
			} else if(!stack.isEmpty()&&s.charAt(i)==')'&&stack.peek()=='(') {
				stack.pop();
			} else if(!stack.isEmpty()&&s.charAt(i)=='}'&&stack.peek()=='{') {
				stack.pop();
			} else if(!stack.isEmpty()&&s.charAt(i)==']'&&stack.peek()=='[') {
				stack.pop();
			} else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
			    return 0;
			}
			i++;
		}
		
		if (stack.isEmpty()) return 1;
		else return 0;
	}
}