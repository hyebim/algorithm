import java.util.*;

class Solution {

    public int solution(String[] maps) {
        int answer = 0;
        
        char[][] map = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            char[] ch = maps[i].toCharArray();
            for(int j = 0; j < maps[0].length(); j++) {
                map[i][j] = ch[j];
                // System.out.print(map[i][j]);
            }              
        }
        
        int sx = -1;
        int sy = -1;
        int lx = -1;
        int ly = -1;
        int gx = -1;
        int gy = -1;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {               
                if(map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if(map[i][j] == 'L') {
                    lx = i;
                    ly = j;
                } else if(map[i][j] == 'E') {
                    gx = i;
                    gy = j;
                }
            }
        }

        if(BFS(map, sx, sy, lx, ly) == -1 || BFS(map, sx, sy, gx, gy) == -1) {
            answer = -1;
        } else {
            answer = BFS(map, sx, sy, lx, ly) + BFS(map, lx, ly, gx, gy);
        }
        
        return answer;
    }
    
    public int BFS(char[][] map, int i, int j, int gx, int gy) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int dis = 0;
        boolean[][] visited = new boolean[map.length][map[0].length];
        
        queue.offer(new int[]{i, j, dis});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int x = 0; x < 4; x++) {
                int nx = cur[0] + dx[x];
                int ny = cur[1] + dy[x];
                dis = cur[2] + 1;
                
                if(gx == nx && gy == ny) {
                    return dis;
                }
                
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }
                
                if(map[nx][ny] == 'X') {
                    continue;
                }
                
                
                if(visited[nx][ny]) {
                    continue;
                }
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dis});
            }

        }
        
        return -1;
    }
}