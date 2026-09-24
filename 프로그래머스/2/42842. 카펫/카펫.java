import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        
        ArrayList<Integer> arr = func(yellow);
        for(int i = 0; i < arr.size(); i++) {
                if(arr.get(i)*2 + yellow/arr.get(i)*2 + 4 == brown) {
                    answer[0] = yellow/arr.get(i)+2;
                    answer[1] = arr.get(i)+2;
                    break;
                }
            }
        
        return answer;
    }
    
    // 약수 반만 담기
    public ArrayList<Integer> func(int yellow) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i*i <= yellow; i++) {
            if(yellow%i==0) {
                arr.add(i);
            }
        }
        return arr;
    }
}