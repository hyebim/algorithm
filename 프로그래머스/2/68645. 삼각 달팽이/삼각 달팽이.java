class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        int[][] arr = new int[n][n];
        int row = -1;
        int col = 0;
        int num = 1;
        
        int len = n; 
        while(len > 0) {
            // 행 아래로
            for(int i = 0; i < len; i++) {
                row++;
                arr[row][col] = num;
                num++;
            }
            len--;
            
            // 열 오른쪽으로
            for(int i = 0; i < len; i++) {
                col++;
                arr[row][col] = num;
                num++;
            }
            len--;
            
            for(int i = 0; i < len; i++) {
                row--;
                col--;
                arr[row][col] = num;
                num++;
            }
            len--;
        }
        
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        answer = new int[sum];
        
        int k = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                // System.out.print(arr[i][j] + " ");
                answer[k] = arr[i][j];
                k++;
            }
        }
        return answer;
    }
}