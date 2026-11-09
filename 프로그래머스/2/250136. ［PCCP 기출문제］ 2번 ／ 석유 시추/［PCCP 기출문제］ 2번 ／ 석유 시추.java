import java.util.*;
class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    boolean[][] visited;
    int[] oil;
    // int amount;
    
    public int solution(int[][] land) {
        int answer = 0;
        visited = new boolean[land.length][land[0].length];
        oil = new int[land[0].length];
        
        for(int j = 0; j < land[0].length; j++) {
            for(int i = 0; i < land.length; i++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    list.add(BFS(land, i, j));
                }
            }
        }
    
        Arrays.sort(oil);
        answer = oil[land[0].length-1];
        
        return answer;
    }
    
    public int BFS(int[][] land, int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        HashSet<Integer> col = new HashSet<>();
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int amount = 0;
        
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            amount++;
            
            col.add(cur[1]);
            
            for(int x = 0; x < 4; x++) {
                int nx = dx[x] + cur[0];
                int ny = dy[x] + cur[1];
                
                if(nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length) {
                    continue;
                }
                
                if(visited[nx][ny]) {
                    continue;
                }
                
                if(land[nx][ny] == 0) {
                    continue;
                }
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
        
        for(int n : col) {
            oil[n] += amount;
            // System.out.print(oil[n] + " ");
        }
        
        return amount;
    }
}