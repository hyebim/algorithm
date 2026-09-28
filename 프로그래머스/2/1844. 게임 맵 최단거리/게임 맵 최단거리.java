import java.util.*;
class Solution {
    boolean[][] visited;
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        
        answer = BFS(maps);
        return answer;
    }
    
    public int BFS(int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        visited[0][0] = true;
        queue.offer(new int[]{0, 0, 1});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int dis = cur[2];
                
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                }
                
                if(nx==maps.length-1 && ny==maps[0].length-1) {
                    return dis+1;
                }
                
                if(visited[nx][ny]) {
                    continue;
                }
                
                if(maps[nx][ny] == 0) {
                    continue;
                }
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dis+1});
                
            }

        }
        
        return -1;
    }
}