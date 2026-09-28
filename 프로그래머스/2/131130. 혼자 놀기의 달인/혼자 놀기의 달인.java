import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++) {
            int boxIdx = i;
            int cnt = 0;

            while (!visited[boxIdx]) {
                visited[boxIdx] = true;
                cnt++;

                boxIdx = cards[boxIdx] - 1; // 다음 상자로 이동
            }

            list.add(cnt);
        }
        
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        if(arr[arr.length-1]*arr[arr.length-2] > 0) {
            answer = arr[arr.length-1]*arr[arr.length-2];
        } else {
            answer = 0;
        }
        
        return answer;
    }
    
    
}