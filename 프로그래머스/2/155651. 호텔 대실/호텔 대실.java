import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] time = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++) {
            for(int j = 0; j < 2; j++) {
                String[] split = book_time[i][j].split(":");
                time[i][j] = Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
                if(j==1) time[i][j]+=10;
            }
        }
        
        Arrays.sort(time, (a, b) -> Integer.compare(a[0], b[0]));
        
        // for(int i = 0; i < book_time.length; i++) {
        //     for(int j = 0; j < 2; j++) {
        //         System.out.print(time[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(time[0][1]);
        for(int i = 1; i < time.length; i++) {
            boolean book = false;
            int j = 0;
            while(j < arr.size()){
                if(arr.get(j) <= time[i][0]) {
                    arr.set(j, time[i][1]);
                    book = true;
                    break;
                }
                j++;
            }
                
            if(!book) {
                arr.add(time[i][1]);
            }
            
        }
        
        answer = arr.size();
        return answer;
    }
}