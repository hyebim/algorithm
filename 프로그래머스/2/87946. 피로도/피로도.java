class Solution {
    boolean[] visited;
    int answer = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
             
        visited = new boolean[dungeons.length];
        DFS(k, dungeons, 0, k);
        
        return answer;
    }
    
    public void DFS(int k, int[][] dungeons, int count, int rest) {
        for(int i = 0; i < dungeons.length; i++) {
            answer = Math.max(answer, count);
            
            if(!visited[i] && dungeons[i][0] <= rest) {
                visited[i] = true;
                DFS(k, dungeons, count+1, rest-dungeons[i][1]);
                visited[i] = false;
            } 
        }
    
    }
}