class Solution {
    public String solution(String s) {
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	
        	if(ch == ' ') {
        		sb.append(ch);
        		first = true;
        	} else if (first){
        		if(Character.isLowerCase(ch)) {
        			sb.append(Character.toUpperCase(ch));
        		} else if(Character.isUpperCase(ch)) {
        			sb.append(ch);
        		} else sb.append(ch);
        		first = false;
        	} else {
        		if(Character.isUpperCase(ch)) {
        			sb.append(Character.toLowerCase(ch));
        		}
        		else {
            		sb.append(ch);
            	}
        		first = false;
        	}
        	
        }
        return sb.toString();
    }
}