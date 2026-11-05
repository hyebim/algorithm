import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
            // System.out.println(phone_book[i]);
            HashSet<String> set = new HashSet<>();
            int length = phone_book[i].length();
            set.add(phone_book[i]);
            if(length > phone_book[i+1].length()) {
                continue;
            } else {
                set.add(phone_book[i+1].substring(0, length));
                if(set.size() == 1) {
                    return false;
                }
            }
            
            // if(phone_book[i].startsWith(phone_book[i+1].substring(0, length))) {
            //     return false;
            // }
        }
        
        return true;
    }
}