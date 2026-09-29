import java.util.*;
class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    int answer = 0;
    public int solution(int n, int[][] computers) {
        // int answer = 0;
        visited = new boolean[n];
        
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && computers[i][j] == 1) {
                    graph[i].add(j);
                    // System.out.print(i + " " + j);
                    // System.out.println();
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                DFS(i);
            }
        }

        return answer;
    }
    
    public void DFS(int node) {
        visited[node] = true;
        
        for(int next : graph[node]) {
            if(!visited[next]) {
                DFS(next);
            } 
        }

    }
}