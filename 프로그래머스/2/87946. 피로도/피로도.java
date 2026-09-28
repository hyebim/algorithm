class Solution {
    boolean[] visited;
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        DFS(k, dungeons, 0);
        
        return answer;
    }
    
    public void DFS(int k, int[][] dungeons, int cnt) {
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                DFS(k-dungeons[i][1], dungeons, cnt+1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, cnt);
    }
}