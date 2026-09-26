import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = BFS(maps);
        
        return answer;
    }
    
    public int BFS(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true; // 방문처리
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
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
                
                if(nx==maps.length-1 && ny==maps[0].length-1) {
                    return cur[2]+1;
                }
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, cur[2]+1});
                // System.out.println(cur[2]);
            }
        }
        
        return -1;
    }
}