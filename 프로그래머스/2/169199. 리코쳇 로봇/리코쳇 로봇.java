import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        Character[][] boards = new Character[board.length][board[0].length()];
        int sx = 0;
        int sy = 0;
        for(int i = 0; i < board.length; i++) {
            char[] ch = board[i].toCharArray();
            for(int j = 0; j < board[0].length(); j++) {
                boards[i][j] = ch[j];
                if(ch[j]=='R') {
                    sx = i;
                    sy = j;
                } 
            }
        }
    
        answer = BFS(sx, sy, boards);
        
        return answer;
    }
    
    public int BFS(int sx, int sy, Character[][] boards) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[boards.length][boards[0].length];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        visited[sx][sy] = true;
        queue.offer(new int[]{sx, sy, 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= boards.length || ny < 0 || ny >= boards[0].length) {
                    continue;
                }
                
                if(boards[nx][ny] == 'D') {
                    continue;
                }
                
                // if(visited[nx][ny]) {
                //     continue;
                // }
                
                while(nx >= 0 && nx < boards.length && ny >= 0 && ny < boards[0].length && boards[nx][ny] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                nx = nx - dx[i];
                ny = ny - dy[i];
                
                if(visited[nx][ny]) {
                    continue;
                }
                
                if(boards[nx][ny]=='G') {
                    return d+1;
                }
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, d+1});
            }           
        }
        
        return -1;
    }
}