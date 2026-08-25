import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        answer = new int[2];
        
        ArrayList<int[]> list = new ArrayList<>();
        int sum = sequence[0];
        int start = 0;
        int end = 0;
        while(start <= end) {
        	if(sum < k) {
        		end++;
        		if(end >= sequence.length) break;
        		sum += sequence[end];
        	} else if(sum == k) {
        		list.add(new int[]{start, end});
        		sum -= sequence[start];
        		start++;
        	} else {
        		sum -= sequence[start];
        		start++;
        	}
        }
        
        ArrayList<Integer> differ = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
//        	System.out.print(Arrays.toString(list.get(i)));
        	differ.add(list.get(i)[1]-list.get(i)[0]);
//        	System.out.print(differ.get(i));
        }
        
        int min = differ.get(0);
        answer[0] = list.get(0)[0];
    	answer[1] = list.get(0)[1];
        for(int i = 0; i < list.size(); i++) {
        	if(differ.get(i) < min) {
        		min = differ.get(i);
        		answer[0] = list.get(i)[0];
            	answer[1] = list.get(i)[1];
        	}
        }
        return answer;
    }
}