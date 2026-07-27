import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> left = new HashSet<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        for(int i = 0; i < topping.length; i++) {
        	right.put(topping[i], right.getOrDefault(topping[i], 0)+1);
        }
        
        for(int i = 0; i < topping.length; i++) {
        	int cur = topping[i];
        	
        	left.add(cur);
        	right.put(cur, right.getOrDefault(cur, 0)-1);
        	if(right.get(cur)==0) right.remove(cur);
        	
        	if(left.size()==right.size()) answer++;
        }
        
//        HashSet<Integer> set1 = new HashSet<>();
//        HashSet<Integer> set2 = new HashSet<>();
//        for(int i = 1; i < topping.length; i++) {
//        	for(int j = 0; j < i; j++) {
//        		set1.add(topping[j]);
//        	}
//        	for(int k = i; k < topping.length; k++) {
//        		set2.add(topping[k]);
//        	}
////        	System.out.println(set1.size() + " " + set2.size());
//        	if(set1.size()==set2.size()) answer++;
//        }
        return answer;
    }
}