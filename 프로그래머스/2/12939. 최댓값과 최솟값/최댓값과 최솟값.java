class Solution {
    public String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int[] num = new int[s.split(" ").length];
        for(int i = 0; i < num.length; i++) {
        	String[] split = s.split(" ");
//        	System.out.print(split[i]);
        	num[i] = Integer.parseInt(split[i]);
        	max = Math.max(max, num[i]);
        	min = Math.min(min, num[i]);
        }
        
        answer += min + " " + max;
        return answer;
    }
}