import java.util.*;
class Solution {
    boolean[][] visited;
        
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        visited = new boolean[maps.length][maps[0].length()];
        
        Character[][] map = new Character[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            char[] ch = maps[i].toCharArray();
            for(int j = 0; j < maps[0].length(); j++) {
                map[i][j] = ch[j];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 'X') {
                    continue;
                }
                
                if(visited[i][j]) {
                    continue;
                }
                
                list.add(BFS(i, j, map));
            }
        }
        
        if(list.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
        }
        
        return answer;
    }
    
    public int BFS(int sx, int sy, Character[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        visited[sx][sy] = true;
        queue.offer(new int[]{sx, sy});
        int day = map[sx][sy]-'0';
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            // day += (map[sx][sy]-'0');
            
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
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                day += (map[nx][ny]-'0');
                
            }
            
        }
        
        return day;
    }
}