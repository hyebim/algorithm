import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0; 
        
        for(int i = 0; i < skill_trees.length; i++) {
        	Queue<Character> q = new LinkedList<>();
            for(int j = 0; j < skill.length(); j++) {
            	q.offer(skill.charAt(j));
            }
            
        	char[] ch = skill_trees[i].toCharArray();
        	int k = 0;
        	Queue<Character> treeq = new LinkedList<>();
        	while(k < skill_trees[i].length()) {
        		if(q.contains(ch[k])) {
        			treeq.offer(ch[k]);
        		}
        		k++;
        	}
        	
        	while(!treeq.isEmpty()) {
        		if(q.peek().equals(treeq.peek())) {
        			q.poll();
        			treeq.poll();
        			
        		} else break;
        	}
        	
        	if(treeq.isEmpty()) answer++;
        	
        }
        return answer;
    }
}