import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        int cnt = 0;
        String[] num = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
            if(num[i].equals("0")) {
                cnt++;
            }
        }
        
        if(cnt == num.length) {
            return "0";
        }
        Arrays.sort(num, (a, b) -> (b + a).compareTo(a + b));
        for(int i = 0; i < num.length; i++) {
            answer += num[i];
        }     
        
        return answer;
    }
}