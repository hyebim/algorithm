import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
    
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < weights.length; i++) {
            map.put(weights[i], map.getOrDefault(weights[i], 0)+1);
        }
        
        for(int key : map.keySet()) {
            if(map.get(key) > 1) {
                answer += (long)map.get(key)*(map.get(key)-1)/2;
            }
            
            if(key * 2 % 3 == 0) {
                int target = key * 2 / 3;
                if(map.containsKey(target)) {
                    answer += (long)map.get(key) * map.get(target);
                }
            }
            
            if(key % 2 == 0) {
                int target = key / 2;
                if(map.containsKey(target)) {
                    answer += (long)map.get(key) * map.get(target);
                }
            }
            
            if(key * 3 % 4 == 0) {
                int target = key * 3 / 4;
                if(map.containsKey(target)) {
                    answer += (long)map.get(key) * map.get(target);
                }
            }
        }
        
        return answer;
    }
}