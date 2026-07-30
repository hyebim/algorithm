import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
        	if(s.charAt(i)=='{') {
        		i++;
        		
        		StringBuilder keep = new StringBuilder();
        		ArrayList<Integer> current = new ArrayList<>();
        		while(s.charAt(i)!='}') {
        			if(Character.isDigit(s.charAt(i))) {
        				keep.append(s.charAt(i));
            		} else if(s.charAt(i)==',') {
            			int num = Integer.parseInt(keep.toString());
            			current.add(num);
            			
            			keep.setLength(0); // 숫자 처리 후 비우기
            		}
        			i++;
        		}
        		
        		// } 앞 숫자도 저장
        		if(keep.length() > 0) {
        			int num = Integer.parseInt(keep.toString());
        			current.add(num);
        		}
        		
        		list.add(current);

        	}
        	i++;
        }
        
        list.sort((a, b) -> a.size() - b.size());
//        System.out.print(list);
        
        HashSet<Integer> set = new HashSet<>();
        answer = new int[list.size()];
        int idx = 0;
        for(int j = 0; j < list.size(); j++) {
        	for(int k = 0; k < list.get(j).size(); k++) {
        		int num = list.get(j).get(k);
        		
        		if(!set.contains(num)) {
        			set.add(num);
        			answer[idx++] = num;
        		}
        	}
        }

        return answer;
    }
}