class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][4];
        for(int i = 0; i < 4; i++) {
        	dp[0][i] = land[0][i];
        }
        
        for(int i = 1; i < land.length; i++) {
        	for(int j = 0; j < 4; j++) {
        		int max = Integer.MIN_VALUE;
        		for(int k = 0; k < 4; k++) {
        			if(k == j) continue;
        			else {
        				max = Math.max(max, land[i-1][k]);
        			}
        		}
        		dp[i][j] += max + land[i][j];
        		land[i][j] = dp[i][j];
        	}
        }
        
//        for(int i = 0; i < dp.length; i++) {
//        	for(int j = 0; j < 4; j++) {
//        		System.out.print(dp[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        
        answer = Integer.MIN_VALUE;
        for(int i = 0; i < 4; i++) {
        	answer = Math.max(answer, dp[dp.length-1][i]);
        }

        return answer;
    }
}