import java.util.*;
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            orders[i] = new String(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < course.length; i++) {
            for(int j = 0; j < orders.length; j++) {
                comb(orders[j], course[i], 0, sb);
            }
            
            int max = 0;
            for(String key : map.keySet()) {
                max = Math.max(max, map.get(key));
            }

            for(String key : map.keySet()) {
                if(map.get(key) >= 2 && map.get(key) >= max) {
                    list.add(key);
                }
            }
            
            map.clear();
        }
        
        Collections.sort(list);
        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            // System.out.print(list.get(i));
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void comb(String str, int n, int start, StringBuilder sb) {
        
        if(n == sb.length()) {
            String menu = sb.toString();
            map.put(menu, map.getOrDefault(menu, 0)+1);
            return;
        }
        
        char[] ch = str.toCharArray();
        for(int i = start; i < ch.length; i++) {
            sb.append(ch[i]);
            comb(str, n, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}