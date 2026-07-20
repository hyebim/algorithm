import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        answer = new int[2];
        
       HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        
        boolean found = false;
        
        for(int i = 0; i < words.length-1; i++) {
        	char ch1 = words[i].charAt(words[i].length()-1);
        	char ch2 = words[i+1].charAt(0);
        	if(ch1 != ch2) {
        		answer[0] = (i+1)%n+1;
        		answer[1] = (i+1)/n+1;
        		break;
        	} 
        	
//        	ArrayList<String> usedWords = new ArrayList<>();
        	for(int j = 0; j < set.size(); j++) {
        		if(set.contains(words[i+1])) {
        			answer[0] = (i+1)%n+1;
            		answer[1] = (i+1)/n+1;
            		found = true;
            		break;
        		}
        	}
        	if(found) break;
        	else set.add(words[i+1]);
        }

        return answer;
    }
}
