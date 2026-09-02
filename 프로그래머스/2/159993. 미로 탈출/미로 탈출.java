import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        int sx = 0;
        int sy = 0;
        int lx = 0;
        int ly = 0;
        Character[][] map = new Character[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            char[] ch = maps[i].toCharArray();
            for(int j = 0; j < maps[0].length(); j++) {
                map[i][j] = ch[j];
                if(ch[j] == 'S') {
                    sx = i;
                    sy = j;
                } else if(ch[j] == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }
  
        int first = BFS(sx, sy, map, 'L');
        int second = BFS(lx, ly, map, 'E');
        
        if(first == -1 || second == -1) answer = -1;
        else answer = first + second;
        
        return answer;
    }
    
    public int BFS(int startX, int startY, Character[][] map, char goal) {
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        visited[startX][startY] = true; // 시작점 방문 처리
        queue.offer(new int[]{startX, startY, 0}); // 시작점 큐에 삽입
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int d = current[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }
                
                if(visited[nx][ny]) {
                    continue;
                }
                
                if(map[nx][ny] == 'X') {
                    continue;
                }
                
                if(map[nx][ny] == goal) {
                    return d+1;
                }
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, d+1});
            }
        }
        return -1;
    } 
}