import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int a = arrayA[0];
        for(int i = 0; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
        }
        
        int b = arrayB[0];
        for(int i = 0; i < arrayB.length; i++) {
            b = gcd(b, arrayB[i]);
        }
        
        boolean possibleA = true;
        boolean possibleB = true;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] % b == 0) {
                possibleB = false;
            } 
            
            if(arrayB[i] % a == 0) {
                possibleA = false;
            } 
        }
        
        if (possibleA) {
            answer = Math.max(answer, a);
        }

        if (possibleB) {
            answer = Math.max(answer, b);
        }
        
        return answer;
    }
    
    // 최대공약수 구하는 함수
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
    return a;
    }

}