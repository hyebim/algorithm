import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < phone_book.length; i++) {
            set.add(phone_book[i]);
        }
        
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length-1; i++) {
            for(int j = 1; j < phone_book[i+1].length(); j++) {
                String prefix = phone_book[i+1].substring(0, j);
                if(prefix.equals(phone_book[i])) return false;
            }
        }
        
        return true;
    }
}