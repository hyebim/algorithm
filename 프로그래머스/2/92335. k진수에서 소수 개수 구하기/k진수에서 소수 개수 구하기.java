class Solution {
    public static int solution(int n, int k) {
        int answer = 0;
        
        String str = Integer.toString(n, k);
        String[] arr = str.split("0");
        
        for(int i = 0; i < arr.length; i++) {
        	if(isPrime(arr[i])) {
//        		System.out.print(arr[i] + " ");
        		answer++;
        	}
        }
        return answer;
    }
    
    public static boolean isPrime(String n) {
    	if (n.isEmpty()) return false;

        long num = Long.parseLong(n);

        if (num <= 1) return false;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
    	
    	return true;
    }
}