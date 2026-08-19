import java.util.*;
class Solution {
    public static String[] solution(String[] files) {
    	
        Arrays.sort(files, (String a, String b) -> {
        	String headA = getHead(a);
        	String headB = getHead(b);
        	
        	int numA = getNumber(a);
        	int numB = getNumber(b);
        	
        	int result = headA.compareToIgnoreCase(headB);
        	if(result == 0) {
        		return Integer.compare(numA, numB);
        	}
        	
        	return result;
        });
        
        return files;
    }
    
    public static String getHead(String file) {
    	char[] ch = file.toCharArray();
    	int j = 0;
    	
    	StringBuilder head = new StringBuilder();
    	while(j < ch.length && !Character.isDigit(ch[j])) {
    		head.append(Character.toLowerCase(ch[j]));
    		j++;
    	}
    	
    	return head.toString();
    }
    
    public static int getNumber(String file) {
    	char[] ch = file.toCharArray();
    	int j = 0;
    	
    	StringBuilder num = new StringBuilder();
    	while(j < ch.length && !Character.isDigit(ch[j])) {
    		j++;
    	}
    	
    	while(j < ch.length && Character.isDigit(ch[j])) {
    		num.append(ch[j]);
    		j++;
    	}
    	int number = Integer.parseInt(num.toString());
    	
    	return number;
    }
}