class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        int dir = 0;
        boolean[][][] visit = new boolean[11][11][5];
        for(char ch : dirs.toCharArray()) {
        	if(ch == 'U') {
        		if(x >= 10) continue;
        		else {
        			x++;
        			dir = 1;
        		}
        		
        	} else if(ch == 'D') {
        		if(x <= 0) continue;
        		else {
        			x--;
        			dir = 2;
        		}
        	} else if(ch == 'R') {
        		if(y >= 10) continue; 
        		else {
        			y++;
        			dir = 3;
        		}
        	} else if(ch == 'L') {
        		if(y <= 0) continue;
        		else {
        			y--;
        			dir = 4;
        		}
        	}
        	
        	if(visit[x][y][dir]==false) {
        		if(dir==1) {
        			visit[x][y][1] = true;
            		visit[x-1][y][2] = true;
        		} else if(dir==2){
        			visit[x][y][2] = true;
        			visit[x+1][y][1] = true;
        		} else if(dir==3) {
        			visit[x][y][3] = true;
            		visit[x][y-1][4] = true;
        		} else if(dir==4) {
        			visit[x][y][4] = true;
            		visit[x][y+1][3] = true;
        		}
        		answer++;
        	}
        }
        return answer;
    }
}