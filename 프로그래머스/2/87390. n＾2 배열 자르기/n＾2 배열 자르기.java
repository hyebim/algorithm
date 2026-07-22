class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        answer = new int[(int) (right-left+1)];
        
//        int ans[] = new int[n*n];
//        for(int i = 0; i < n*n; i++) {
//        	ans[i] = Math.max(i/n, i%n) + 1;
//        }
        
//        for(long i = left; i < right+1; i++) {
//        	System.out.print(ans[(int) i]);  
//        	
//        }
        
        for(long i = 0; i < right-left+1; i++) {
        	long index = i+left;
        	long row = index / n;
        	long col = index % n;
        	answer[(int) i] = (int) (Math.max(row, col) + 1);
        }
        return answer;
    }
}