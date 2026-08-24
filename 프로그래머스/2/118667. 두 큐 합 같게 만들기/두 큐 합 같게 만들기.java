import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < queue1.length; i++) {
        	q1.offer(queue1[i]);
        	q2.offer(queue2[i]);
        	sum1 += queue1[i];
        	sum2 += queue2[i];
        }
        
        if((sum1+sum2)%2!=0) {
        	return -1;
        }
        
        while(answer < (q1.size()+q2.size())*2) {
        	if(sum1 == sum2) {
        		return answer;
        	}
        	
        	if(sum1 > sum2) {
        		int item = q1.poll();
        		q2.offer(item);
        		sum1 -= item;
        		sum2 += item;
        		answer++;
        	} else if(sum1 < sum2) {
        		int item = q2.poll();
        		q1.offer(item);
        		sum1 += item;
        		sum2 -= item;
        		answer++;
        	}
        }
        return -1;
    }
}