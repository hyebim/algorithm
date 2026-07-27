import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < phone_book.length; i++) {
        	set.add(phone_book[i]);
        }
        
        for(String phone : set) {
        	for(int i = 0; i < phone.length(); i++) {
        		String pre = phone.substring(0, i);
        		
        		if(set.contains(pre)) {
        			answer = false;
        			break;
        		}
        	}
        }
        return answer;
    }
}