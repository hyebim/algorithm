class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        if(fun1(storey) < fun3(storey)) {
            answer = fun1(storey);
        } else {
            answer = fun3(storey);
        }

        // System.out.print(fun3(storey));
        
        return answer;
    }
    
    public int fun3(int storey) {
        int cnt = 0;
        int num = 0;
        while(storey > 0) {
            if(storey % 10 > 5) {
                cnt = (10 - (storey % 10));
                storey += cnt;
            } else if(storey % 10 < 5){
                cnt = (storey % 10);
            } else {
                cnt = 5;
                
                if((storey/10)%10 >= 5) {
                    storey += cnt;
                } 
                
            }
            
            num += cnt;
            // storey += cnt;
            storey /= 10;
            // System.out.println(storey);
        }
        
        return num;
    }
    
    public int fun1(int storey) {
        int cnt = 0; 
        while(storey > 0) {
            cnt += (storey % 10);
            storey = storey / 10;
        }
        return cnt;
    }
}