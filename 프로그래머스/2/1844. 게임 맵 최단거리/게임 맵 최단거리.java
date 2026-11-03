import java.util.*;
class Solution {
    int answer;
    public int solution(int[][] maps) {
        
        answer = BFS(maps);
        
        return answer;
    }
    
    public int BFS(int[][] maps) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int x = cur[0];
            int y = cur[1];
            int dis = cur[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx == maps.length-1 && ny == maps[0].length-1) {
                    return dis+1;
                }
                
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                    continue;
                }
                
                if(maps[nx][ny] == 0) {
                    continue;
                }
                
                if(visited[nx][ny]) {
                    continue;
                }
                
                queue.offer(new int[]{nx, ny, dis+1});
                visited[nx][ny] = true;
                
            }
            
        }
        
        return -1;
    }
}