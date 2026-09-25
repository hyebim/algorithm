class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        DFS(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void DFS(int[] numbers, int target, int total, int i) {
        if(i == numbers.length) {
            if(total == target) {
                answer++;
            }
            return;
        }
        
        DFS(numbers, target, total+numbers[i], i+1);
        DFS(numbers, target, total-numbers[i], i+1);
    }
}