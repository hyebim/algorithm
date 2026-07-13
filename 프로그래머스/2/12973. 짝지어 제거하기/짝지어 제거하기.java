import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
		int i = 0;
		while(i < s.length()) {
			if(i==0) stack.push(s.charAt(i));
			else {
				if(!stack.isEmpty() && stack.peek().equals(s.charAt(i)))
					stack.pop();
				else stack.push(s.charAt(i));
			}
			i++;
		}
		
		if(stack.isEmpty()) return 1;
		else return 0;
    }
}