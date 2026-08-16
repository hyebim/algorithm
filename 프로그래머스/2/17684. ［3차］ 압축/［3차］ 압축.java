import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        // A ~ Z까지 사전에 1 ~ 26 넣기
        for(int i = 1; i < 27; i++) {
        	map.put(Character.toString((char)'A' + i - 1), i);
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        int i = 0;
        int j = 0; // 어디까지 늘렸는지
        while(i < msg.length()) {
        	String w = Character.toString(msg.charAt(i)); // 현재입력
//        	String c = Character.toString(msg.charAt(j+1)); // 다음글자
        	
        	while(map.containsKey(w)) {
        		String prev = w;
        		
        		if(j+1 >= msg.length()) {
        			arr.add(map.get(prev));
        			i = msg.length();
        			break;
        		}
        		
        		String c = Character.toString(msg.charAt(j+1)); // 다음글자
        		w += c;
        		if(map.containsKey(w)) {
        			j++;
        		}
        		else {
        			arr.add(map.get(prev));
        			map.put(w, map.size()+1);
//        			System.out.println(map.get(w));
        			i += w.length()-1;
        			j = i;
        			break;
        		}
        		
        	}
        	
        }
        
        answer = new int[arr.size()];
        for(int k = 0; k < arr.size(); k++) {
        	answer[k] = arr.get(k); 
        }
        return answer;
    }
}