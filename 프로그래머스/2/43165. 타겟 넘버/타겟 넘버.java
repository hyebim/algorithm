class Solution {
    static int answer = 0;
	
	public static int solution(int[] numbers, int target) {
        
        DFS(numbers, -1, 0, target);
        
        return answer;
    }
	
	// 현재 계산한 합이 얼마인지 가지고 다음 노드로 넘어가야함 
	public static void DFS(int[] numbers, int idx, int sum, int target) {
		
		if(numbers.length==idx+1) {
			if(target==sum) {
				answer++;
			} 
			return;
		}
		
		DFS(numbers, idx+1, sum+numbers[idx+1], target);
		DFS(numbers, idx+1, sum-numbers[idx+1], target);

	}
}