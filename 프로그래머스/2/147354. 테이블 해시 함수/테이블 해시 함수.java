import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(data, (a, b) -> {
            if(a[col-1] == b[col-1]) return Integer.compare(b[0], a[0]);
            
            return Integer.compare(a[col-1], b[col-1]);
        });
        
        // for(int i = 0; i < data.length; i++) {
        //     for(int j = 0; j < data[0].length; j++) {
        //         System.out.print(data[i][j] + " ");
        //     }
        //     System.out.println();
        // }
          
        int[] sum = new int[row_end-row_begin+1];
        for(int i = row_begin-1; i < row_end; i++) {
            int num = 0;
            for(int j = 0; j < data[0].length; j++) {
                num += (data[i][j]%(i+1));
            }
            // System.out.println(num);
            sum[i-(row_begin-1)] = num;
        }
        
        for(int i = 0; i < sum.length; i++) {
            answer ^= sum[i];
        }
        
        return answer;
    }
}