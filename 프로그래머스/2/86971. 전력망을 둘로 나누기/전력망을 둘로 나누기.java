import java.util.*;
class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    int count; 
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
     
        graph = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++) {
            graph[wires[i][1]].add(wires[i][0]);
            graph[wires[i][0]].add(wires[i][1]);
        }
        
        int cutA = 0;
        int cutB = 0;
        for(int i = 0; i < wires.length; i++) {
            visited = new boolean[n+1];
            count = 0;
            
            cutA = wires[i][0];
            cutB = wires[i][1];
            
            DFS(1, cutA, cutB);
            
            answer = Math.min(answer, Math.abs(count-(n-count)));
        }
        
        return answer;
    }
    
    public void DFS(int node, int cutA, int cutB) {
        visited[node] = true;
        count++; // 노드를 처음 방문한 순간 증가시켜주어야함
        
        for(int next : graph[node]) {
            if((node == cutA && next == cutB) ||
                (node == cutB && next == cutA)) {
                    continue;
            }
            
            if(!visited[next]) {
                DFS(next, cutA, cutB);
            }
        }        
    }
}