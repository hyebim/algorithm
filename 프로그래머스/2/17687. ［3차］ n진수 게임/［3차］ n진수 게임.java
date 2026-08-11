class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String num = "";
        for(int i = 0; i <= t*m; i++) {
        	num += Integer.toString(i, n);
        }
        
        String str = "";
        for(int i = 0; i < num.length(); i++) {
        	char ch = num.charAt(i);
        	if(i%m == p-1) {
        		str += ch;
        	}
        }
        
        for(int i = 0; i < t; i++) {
        	char ch = str.charAt(i);
        	ch = Character.toUpperCase(ch);
        	answer += ch;
        }
        return answer;
    }
}