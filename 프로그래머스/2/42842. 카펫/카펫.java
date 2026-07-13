import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];
        int total = brown+yellow;
        ArrayList<Integer> arr = func(total); // 1 2 3 4 6 12
        for(int i = 0; i <= arr.size()/2; i++) {
        	int h = arr.get(i);
        	int w = total / h;
        	if(w >= h && (w-2)*(h-2)==yellow) {
        		answer[0] = w;
        		answer[1] = h;
        	}
        }
        return answer;
    }
    
    public ArrayList<Integer> func(int num) {
		int i = 1;
		ArrayList<Integer> arr = new ArrayList<>();
		while(i <= num) {
			if(num%i==0) arr.add(i);
			i++;
		}
		return arr;
	}
}