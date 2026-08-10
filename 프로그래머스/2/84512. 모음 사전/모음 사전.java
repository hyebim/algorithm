class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] num = new int[5];
        int i = 0;
        for(char c : word.toCharArray()) {
        	if(c=='A') {
        		num[i] = 1;
        	} else if(c=='E') {
        		num[i] = 2;
        	} else if(c=='I') {
        		num[i] = 3;
        	} else if(c=='O') {
        		num[i] = 4;
        	} else if(c=='U') {
        		num[i] = 5;
        	}
        	i++;
        }
        
        int[] weight = {781, 156, 31, 6, 1};
        for(int j = 0; j < 5; j++) {
            if(num[j] == 0) {
        		break;
        	}
        	answer += (num[j]-1) * weight[j] + 1;
        }
        return answer;
    }
}