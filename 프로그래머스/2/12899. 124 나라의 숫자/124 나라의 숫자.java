class Solution {
    public String solution(int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            if(n % 3 == 0) {
                sb.append(4);
            } else if(n % 3 == 1) {
                sb.append(1);
            } else if(n % 3 == 2) {
                sb.append(2);
            }
            n = (n - 1) / 3;
        }
        
        answer += sb.reverse().toString();
        
        return answer;
    }
}