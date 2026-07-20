import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 사야하는 것. 이거랑 일치해야 answer++
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < number.length; i++) {
        	map.put(want[i], number[i]);
        }
//        System.out.println("사야함: " + map);
        
        int sum = 0;
        for(int i = 0; i < number.length; i++) {
        	sum += number[i]; 
        }
        
        HashMap<String, Integer> dis = new HashMap<>();
        for(int i = 0; i < sum; i++) {
        	dis.put(discount[i], dis.getOrDefault(discount[i], 0)+1); 
        }
//        System.out.println("초기값: " + dis);
        
        if(dis.equals(map)) answer++;
        
        for(int i = 0; i+sum < discount.length; i++) {
        	dis.put(discount[i], dis.getOrDefault(discount[i], 0)-1);
        	if(dis.get(discount[i]) == 0) dis.remove(discount[i]);
        	
    		dis.put(discount[sum+i], dis.getOrDefault(discount[sum+i], 0)+1);
//    		System.out.println(dis);
    		
    		if(dis.equals(map)) answer++;
        }
        
        return answer;
    }
}