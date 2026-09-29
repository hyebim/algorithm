import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = -1;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);       
        for(int i = 1; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }
            stack.push(i);    
        }
        
        
        return answer;
    }
}