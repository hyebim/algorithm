import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length()/2; i++) {
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            
            String str1 = s.substring(0, i);
            
            for(int j = i; j < s.length(); j += i) {       
                String str2 = s.substring(j, Math.min(j + i, s.length()));
                
                if(str1.equals(str2)) {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        sb.append(cnt);
                    } 
                    sb.append(str1);
                    str1 = str2;
                    cnt = 1;
                }
            }
            
            if(cnt > 1) {
                sb.append(cnt);
            }
            sb.append(str1);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}