import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int[] cnt = new int[3];
        int[] p1 = {1, 2, 3, 4, 5}; 
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == p1[i%5]) {
                cnt[0]++;
            }
            
            if(answers[i] == p2[i%8]) {
                cnt[1]++;
            }
            
            if(answers[i] == p3[i%10]) {
                cnt[2]++;
            }
        }
    
        int max = cnt[0];
        for(int i = 0; i < 3; i++) {
            max = Math.max(cnt[i], max);
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(max == cnt[i]) {
                arr.add(i+1);
            }
        }
        
        answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}