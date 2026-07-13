import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++) {
        	map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(Integer key : map.keySet()) {
        	arr.add(map.get(key));
        }
        Collections.sort(arr, Collections.reverseOrder());
        
        for(int num : arr) {
        	k -= num;
        	answer++;
        	if(k <= 0) break;
        }
        
        return answer;
    }
}