import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        int cnt = 0;
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < record.length; i++) {
        	String[] split = record[i].split(" ");
        	
        	if(split[0].equals("Enter")||split[0].equals("Leave")) {
        		cnt++;
        	}
        		 
        	if(split.length == 3) {
        		map.put(split[1], split[2]);
        	}
        	
        }
        
        answer = new String[cnt];
        int idx = 0;
        for(int i = 0; i < record.length; i++) {
        	String[] split = record[i].split(" ");
        	
        	if(split[0].equals("Enter")) {
    			if(map.containsKey(split[1])) {
    				answer[idx] = map.get(split[1]) + "님이 들어왔습니다.";
    				idx++;
    			}
    		} else if(split[0].equals("Leave")) {
    			if(map.containsKey(split[1])) {
    				answer[idx] = map.get(split[1]) + "님이 나갔습니다.";
    				idx++;
    			}
    		}
        }
        return answer;
    }
}