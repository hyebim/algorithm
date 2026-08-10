import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        String[] set1 = new String[str1.length()-1];
        String[] set2 = new String[str2.length()-1];
        for(int i = 0; i < str1.length()-1; i++) {
        	char ch1 = str1.charAt(i);
        	char ch2 = str1.charAt(i+1);
        	StringBuilder sb = new StringBuilder();
        	sb.append(ch1);
        	sb.append(ch2);
        	
        	if(!Character.isLetter(ch1) || !Character.isLetter(ch2)) {
        		continue;
        	} else {
        		set1[i] = sb.toString();
        	}
        }
        
        for(int i = 0; i < str2.length()-1; i++) {
        	char ch1 = str2.charAt(i);
        	char ch2 = str2.charAt(i+1);
        	StringBuilder sb = new StringBuilder();
        	sb.append(ch1);
        	sb.append(ch2);

        	if(!Character.isLetter(ch1) || !Character.isLetter(ch2)) {
        		continue;
        	} else {
        		set2[i] = sb.toString();
        	}
        }

        HashMap<String, Integer> map1 = new HashMap<>();
        for(int i = 0; i < set1.length; i++) {
        	if(set1[i] != null) {
        		map1.put(set1[i], map1.getOrDefault(set1[i], 0)+1);
        	}
        }
        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i = 0; i < set2.length; i++) {
        	if(set2[i] != null) {
        		map2.put(set2[i], map2.getOrDefault(set2[i], 0)+1);
        	}
        }
        
        if(map1.equals(map2)) answer = 65536;
        else {
        	// 교집합 개수
            int count = 0;
            for (String key : map1.keySet()) {
                if (map2.containsKey(key)) {
                    count += Math.min(map1.get(key), map2.get(key));
//                    count2 += Math.max(map1.get(key), map2.get(key));
                }
            }
            System.out.println(count);
            
            int len1 = 0;
            for (String key : map1.keySet()) {
            	len1 += map1.get(key);
            }
            int len2 = 0;
            for (String key : map2.keySet()) {
            	len1 += map2.get(key);
            }
            int sum = len1 + len2 - count;
            
            double similarity = ((double)count/(double)sum);
            answer = (int) (similarity*65536);
        }
        return answer;
    }
}