class Solution {
    boolean[] visited;
    int answer;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer++;
                DFS(i, computers, n);
            }
        }
        return answer;
    }
    
    public void DFS(int idx, int[][] computers, int n) {
        for(int j = 0; j < n; j++) {
            if(!visited[j] && computers[idx][j] == 1) {
                visited[j] = true;
                DFS(j, computers, n);    
            }
        }
    }
}