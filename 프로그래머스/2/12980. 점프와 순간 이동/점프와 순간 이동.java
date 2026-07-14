import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;

        // 짝수면 
        if(n%2==0) { // 반복문 돌리면 안되나,....
        	while(n>1) {
        		if(n%2==0) n = n / 2;
        		else {
        			n = n - 1;
        			ans++;
        		}
        	}
        } else {
        	while(n>1) {
        		if(n%2!=0) {
        			n = n - 1;
        			ans++;
        		} else n = n / 2;
        		
        	}
        }

        return ans;
    }
}