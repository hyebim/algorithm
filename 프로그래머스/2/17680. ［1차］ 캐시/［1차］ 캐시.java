import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        for(int i = 0; i < cities.length; i++) {
        	cities[i] = cities[i].toLowerCase();
        }
        
        Queue<String> queue = new ArrayDeque<>();
        for(int i = 0; i < cities.length; i++) {
        	if(cacheSize == 0) {
        		queue.offer(cities[i]);
        		answer+=5;
        	} else {
        		if(queue.size() > cacheSize-1) {
            		if(!queue.contains(cities[i])) {
            			queue.poll();
            			queue.offer(cities[i]);
            			answer+=5;
            		} else {
            			queue.remove(cities[i]);
                		queue.offer(cities[i]);
                		answer++;
            		}
        		} else if(queue.size() < cacheSize) {
        			if(queue.contains(cities[i])){ 
                		queue.remove(cities[i]);
                		queue.offer(cities[i]);
                		answer++;
                	} else {
                		queue.offer(cities[i]);
                		answer+=5;
                	}
            	}
        	}
        }
        return answer;
    }
}