class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        answer = new int[2];
        
        char[][] parks = new char[park.length][park[0].length()];
        int startx = -1;
        int starty = -1;
        for(int i = 0; i < park.length; i++) {
            char[] ch = park[i].toCharArray();
            for(int j = 0; j < ch.length; j++) {
                parks[i][j] = ch[j];
                if(ch[j] == 'S') {
                    startx = i;
                    starty = j;
                }
            }
        }

        int i = 0;
        while(i < routes.length) {
            boolean possible = true;
            String[] str = routes[i].split(" ");
            String op = str[0];
            int n = Integer.parseInt(str[1]);
            
            int dx = 0;
            int dy = 0;
            if(op.equals("E")) {
                dy = 1;
            } else if(op.equals("W")) {
                dy = -1;
            } else if(op.equals("S")) {
                dx = 1;
            } else if(op.equals("N")) {
                dx = -1;
            }
            
            int nx = startx;
            int ny = starty;
            for(int j = 0; j < n; j++) {
                nx += dx;
                ny += dy;
                
                if(nx < 0 || nx >= parks.length || ny < 0 || ny >= parks[0].length) {
                    possible = false;
                    break;
                }
                
                if(parks[nx][ny] == 'X') {
                    possible = false;
                    break;
                }
    
            }
            
            if(possible) {
                startx = nx;
                starty = ny;
            }
            
            i++;
        }
        
        answer[0] = startx;
        answer[1] = starty;
        return answer;
    }
    
}