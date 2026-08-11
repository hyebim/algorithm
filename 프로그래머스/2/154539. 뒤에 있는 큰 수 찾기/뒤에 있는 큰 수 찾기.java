import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < numbers.length; i++) {
        	while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
        		answer[stack.peek()] = numbers[i];
        		stack.pop();
        	} 
        	stack.push(i);
        }
        
        for(int i = 0; i < answer.length; i++) {
        	if(answer[i] == 0) answer[i] = -1;
        }
        return answer;
    }
}