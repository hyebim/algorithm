import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        answer = BFS(maps);
        
        return answer;
    }
    
    public int BFS(int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, +1, 0, -1};
        
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dis = cur[2];
            
            if (cur[0] == maps.length - 1 &&
                cur[1] == maps[0].length - 1) {
                    return dis;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                } 
                
                if(visited[nx][ny]) {
                    continue;
                }
                
                if(maps[nx][ny] == 0) {
                    continue;
                }
                
                queue.offer(new int[]{nx, ny, dis+1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}