class Solution {
    static int[] answer = new int[2];
    public static int[] solution(int[][] arr) {
        
    	answer = func(arr, 0 ,0, arr.length);
        
        return answer;
    }
    
    public static int[] func(int[][] arr, int row, int col, int size) {
    	boolean isSame = true;
    	int first = arr[row][col];
    	for(int i = row; i < row+size; i++) {
        	for(int j = col; j < col+size; j++) {
        		if(arr[i][j]!=first) {
        			isSame = false;
        		} 
        	}
        }
    	
    	if(isSame) {
    		if(first == 0) {
    			answer[0]++;
    		} else {
    			answer[1]++;
    		}
    	} else {
    		int half = size / 2;
			func(arr, row, col, half); 
			func(arr, row, col + half, half); 
			func(arr, row + half, col, half); 
			func(arr, row + half, col + half, half);
    	}
    	
    	return answer;
    }
}