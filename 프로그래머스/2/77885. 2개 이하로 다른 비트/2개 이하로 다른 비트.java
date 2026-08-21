class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	if(numbers[i]%2==0) {
        		answer[i] = numbers[i]+1;
        	} else {
        		String str = Long.toBinaryString(numbers[i]);
        		str = "0" + str;
        		char[] ch = new char[str.length()];
        		
        		for(int j = 0; j < str.length(); j++) {
        			ch[j] = str.charAt(j);
        		}
        		
        		for(int j = str.length()-1; j >= 0; j--) {
        			if(ch[j] == '0') {
        				ch[j] = '1';
        				ch[j+1] = '0';
        				break;
        			}
        		}
        		
        		String result = new String(ch);
        		answer[i] = Long.parseLong(result, 2);
        	}
        }
        return answer;
    }
}