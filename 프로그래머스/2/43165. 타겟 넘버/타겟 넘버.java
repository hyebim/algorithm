class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        DFS(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void DFS(int[] numbers, int target, int depth, int sum) {
        
        if(numbers.length == depth) {
            if(sum == target) {
                answer++;
                return;
            }
        } else {
            DFS(numbers, target, depth + 1, sum + numbers[depth]);
            DFS(numbers, target, depth + 1, sum - numbers[depth]);
        }
    } 
}