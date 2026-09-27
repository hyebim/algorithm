import java.util.*;
class Solution {
    int[] answer = {};
    public int[] solution(String[][] places) {
        
        answer = new int[5];
        for(int i = 0; i < 5; i++) {
            answer[i] = 1;
        }
    
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                char[] ch = places[i][j].toCharArray();
                for(int l = 0; l < ch.length; l++) {
                    if(ch[l] == 'P') {
                        BFS(places, i, j, l);
                    }
                }
            }
        }
        
        return answer;
    }
    
    public void BFS(String[][] places, int room, int startx, int starty) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<String[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5]; // 필요한가
        
        visited[startx][starty] = true;
        queue.offer(new String[]{String.valueOf(startx), String.valueOf(starty), "0"});
        
        while(!queue.isEmpty()) {
            String[] cur = queue.poll();
                
            for(int d = 0; d < 4; d++) {
                int nx = Integer.parseInt(cur[0]) + dx[d];
                int ny = Integer.parseInt(cur[1]) + dy[d];
                int dis = Integer.parseInt(cur[2]) + 1; //       
                    
                if(nx < 0 || ny < 0 || nx > 4 || ny > 4) continue;
                    
                char next = places[room][nx].charAt(ny);
                    
                if(visited[nx][ny]) continue;
                    
                if(next == 'X') continue;

                if(dis > 2) continue; //
                    
                if(next== 'P') {
                    answer[room] = 0;
                    break;
                }
                    
                queue.offer(new String[]{String.valueOf(nx), String.valueOf(ny), String.valueOf(dis)});
                visited[nx][ny] = true;
                    
                }
             
            }
        }
}
