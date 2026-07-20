import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++) {
        	int sum = 0;
        	
        	for(int j = 0; j < i; j++) {
        		sum += elements[j];
        	}
        	set.add(sum);
        	
        	for(int k = 1; k < elements.length; k++) {
        		sum = sum - elements[k-1];
        		sum = sum + elements[(k+i-1)%elements.length];
        		set.add(sum);
        	}
        }

        
//        for(int i = 1; i <= elements.length; i++) { 
//        	for(int j = 0; j < elements.length; j++) { 
//        		
//        		int sum = 0;
//        		for(int k = 0; k < i; k++) { 
//        			sum += elements[(j + k) % elements.length];
//        			set.add(sum);
//        		}
//        	}
//        }
        
        answer = set.size();
        return answer;
    }
}