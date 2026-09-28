import java.util.*;
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        // 정렬
        for(int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            orders[i] = new String(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < course.length; i++) {
            for(int j = 0; j < orders.length; j++) {
                DFS(orders[j], 0, course[i], sb);
            }
            
            int max = 0;
            for(String key : map.keySet()) {
                max = Math.max(max, map.get(key));
            }
            
            for(String key : map.keySet()) {
                if(map.get(key) >= 2 && map.get(key) >= max) {
                    list.add(key);
                    System.out.println(key + " " + map.get(key));
                }
            }
            map.clear();
            
        }
        
        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public void DFS(String order, int start, int r, StringBuilder sb) {

        if(sb.length() == r) {
            String menu = sb.toString();
            map.put(menu, map.getOrDefault(menu, 0)+1);
        
            return;
        }
        
        for(int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            DFS(order, i+1, r, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
    
}