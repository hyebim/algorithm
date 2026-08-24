import java.util.*;
class Solution {
    static HashSet<Integer> set = new HashSet<>();
	
    public static int solution(String numbers) {
        int answer = 0;
        
        boolean[] visited = new boolean[numbers.length()];
        answer = DFS(numbers, "", visited);
        
        return answer;
    }
    
    public static int DFS(String numbers, String current, boolean[] visited) {

    	for(int i = 0; i < numbers.length(); i++) {
    		if(visited[i]) continue;
    		
    		visited[i] = true;
    		
    		String next = current + numbers.charAt(i);
    		if(isPrime(next)) {
    			set.add(Integer.parseInt(next));
    		}
    		
    		DFS(numbers, next, visited);
    		
    		visited[i] = false;
    	}
    	
    	return set.size();
    }
    
    public static boolean isPrime(String number) {
    	int num = Integer.parseInt(number);
    	
    	if(num < 2) return false;
    	for(int i = 2; i <= Math.sqrt(num); i++) {
    		if(num%i==0) {
    			return false;
    		} 
    	}
    	return true;
    }
}