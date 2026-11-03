class Solution {
    int answer;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        DFS(k, dungeons, k, 0);
        
        return answer;
    }
    
    public void DFS(int k, int[][] dungeons, int sum, int count) {
        answer = Math.max(answer, count);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && sum >= dungeons[i][0]) {
                visited[i] = true;
                DFS(dungeons[i][0], dungeons, sum - dungeons[i][1], count+1);
                visited[i] = false;
            }              
        }
    }
}