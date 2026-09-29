import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        // HashSet<String> set = new HashSet<>();
        // for(int i = 0; i < phone_book.length; i++) {
        //     set.add(phone_book[i]);
        // }
        
        for(int i = 0; i < phone_book.length-1; i++) {
            for(int j = 1; j < phone_book[i+1].length(); j++) {
                String str = phone_book[i+1].substring(0, j);
                if(phone_book[i].equals(str)) {
                    return false;
                } 
            }
        }
        return true;
    }
}