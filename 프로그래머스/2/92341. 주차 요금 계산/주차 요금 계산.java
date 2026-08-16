import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<String, Integer> inMap = new HashMap<>();     // 최근 입차시간
        HashMap<String, Integer> totalMap = new HashMap<>();  // 누적 주차시간
        for(int i = 0; i < records.length; i++) {
        	String[] split = records[i].split(" ");
        	String[] split2 = split[0].split(":");
        	int min =  Integer.parseInt(split2[0]) * 60 + Integer.parseInt(split2[1]);

        	if(split[2].equals("IN")) {
        		inMap.put(split[1], min);
        	} else if(split[2].equals("OUT")) {
        		totalMap.put(split[1], totalMap.getOrDefault(split[1], 0) + min-inMap.get(split[1]));
        		inMap.remove(split[1]);
        	} 
        
        }
        
        for(String key : inMap.keySet()) {
        	if(inMap.get(key)!=null) {
        		totalMap.put(key, totalMap.getOrDefault(key, 0)+1439-inMap.get(key));
        	}
        }
        
        for(String key : totalMap.keySet()) {
        	if(totalMap.get(key) > fees[0]) {
        		int num = (totalMap.get(key)-fees[0])/fees[2];
        		if((totalMap.get(key)-fees[0])%fees[2]!=0) {
        			num++;
        		}
        		int fee = fees[1] + num * fees[3];
        		totalMap.put(key, fee);
        	} else totalMap.put(key, fees[1]);
        }
       
        answer = new int[totalMap.size()];
        int i = 0;
        for(String key : totalMap.keySet()) {
        	answer[i] = Integer.parseInt(key);
        	i++;
        }
        
        Arrays.sort(answer);
        for(int j = 0; j < answer.length; j++) {
        	for(String key : totalMap.keySet()) {
        		if(answer[j]==Integer.parseInt(key)) {
        			answer[j] = totalMap.get(key);
        		}
        	}
        }
        return answer;
    }
}