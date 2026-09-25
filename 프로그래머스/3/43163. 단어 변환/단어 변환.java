import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        answer = BFS(begin, target, words);

        return answer;
    }
    
    public int BFS(String begin, String target, String[] words) {
        Queue<String[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new String[]{begin, "0"});
        
        while(!queue.isEmpty()) {
            String[] cur = queue.poll();
            
            char[] ch = cur[0].toCharArray();
            int count = Integer.parseInt(cur[1]);
            
            for(int i = 0; i < words.length; i++) {
                int cnt = 0;
                char[] wordch = words[i].toCharArray();
                for(int j = 0; j < words[0].length(); j++) {
                    // char[] wordch = words[i].toCharArray();
                    if(ch[j] != wordch[j]) {
                        cnt++;
                    }
                }
                
                if(!visited[i] && cnt == 1) {
                    queue.offer(new String[]{words[i], String.valueOf(count + 1)});
                    visited[i] = true;
                }
            
                if(cur[0].equals(target)) {
                    return count;
                }
            }

        }
        return 0;
    }
}