import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int cnt;
    
    public void DFS(int v, int a, int b) {
        visited[v] = true;
        cnt++;
        
        for(int next : graph.get(v)) {
            if(visited[next]) {
                continue;
            }
            
            if(v==a && next==b) {
                continue;
            }
            
            if(v==b && next==a) {
                continue;
            }
            
            DFS(next, a, b);
        }
    
        
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            visited = new boolean[n+1];
            cnt = 0;
            DFS(a, a, b);
            
            int diff = Math.abs(cnt-(n-cnt));
            answer = Math.min(answer, diff);
            
        }
        return answer;
    }
    
    
}