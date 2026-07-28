import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0}; // 상하좌우 순
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        while(!queue.isEmpty()) {
        	int[] cur = queue.poll();
        	
        	int x = cur[0];
        	int y = cur[1];
        	
        	if(x == maps.length-1 && y == maps[0].length-1) return maps[x][y];
        	
        	for(int i = 0; i < 4; i++) {
        		int nx = x+dx[i];
        		int ny = y+dy[i];
        		if(nx>=0 && ny>=0 && nx<maps.length && ny<maps[0].length
        			&& maps[nx][ny]==1 && !visited[nx][ny]) {
        			visited[nx][ny] = true;
        			maps[nx][ny] = maps[x][y] + 1;
        			queue.offer(new int[] {nx, ny});
        		}
        	}
        }
        
        return -1;
    }
}