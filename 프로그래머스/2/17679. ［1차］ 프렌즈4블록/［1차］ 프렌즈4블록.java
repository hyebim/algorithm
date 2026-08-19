class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] b = new String[m][n];
        for(int i = 0; i < m; i++) {
        	char[] ch = board[i].toCharArray();
        	for(int j = 0; j < n; j++) {
        		b[i][j] = Character.toString(ch[j]);
        	}
        }
        
        while(true) {
        	boolean[][] isTrue = new boolean[m][n];
        	int cnt = 0;
            for(int i = 0; i < m-1; i++) {
            	for(int j = 0; j < n-1; j++) {
            		if(!b[i][j].isEmpty()
            			&& b[i][j].equals(b[i][j+1]) && b[i][j].equals(b[i+1][j+1]) && b[i][j].equals(b[i+1][j])) {
            			isTrue[i][j] = true;
            			isTrue[i][j+1] = true;
            			isTrue[i+1][j+1] = true;
            			isTrue[i+1][j] = true;
            		}
            	}
            }
            
            for(int i = 0; i < m; i++) {
            	for(int j = 0; j < n; j++) {
//            		System.out.print(isTrue[i][j]+ " ");
            		if(isTrue[i][j]) {
            			cnt++;
            			b[i][j] = "";
            		}
            	}
//            	System.out.println();
            }
            
            answer += cnt;
            if(cnt==0) return answer;
            
            for(int j = 0; j < n; j++) {
            	int idx = m-1;
            	for(int i = m-1; i >= 0; i--) {
            		if(!b[i][j].isEmpty()) {
            			b[idx][j] = b[i][j];
            			idx--;
            		}
            	}
            	
            	for(int i = idx; i >= 0; i--) {
            		b[i][j] = "";
            	}
            }
        }
    }
}