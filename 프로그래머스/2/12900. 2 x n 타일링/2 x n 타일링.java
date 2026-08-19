class Solution {
    public static int solution(int n) {
        int answer = 0;
        
        answer = func(n); 
        
        return answer;
    }
    
    public static int func(int n) {
    	int[] dp = new int[n+1];
        
    	dp[2] = 2;
    	dp[3] = 3;
    	
    	for(int i = 4; i < n+1; i++) {
    		dp[i] = (dp[i-1] + dp[i-2])%1000000007;
    	}
    	
    	return dp[n];
    }
}