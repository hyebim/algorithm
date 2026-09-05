class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
            
        int max = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(i > 0 && j > 0 && board[i][j] == 1) {
                    int min = Math.min(board[i][j-1], Math.min(board[i-1][j], board[i-1][j-1]));
                    board[i][j] = min + 1;
                }
                // System.out.print(board[i][j] + " ");
                max = Math.max(max, board[i][j]);
            }
        }
        
        answer = max*max;
        
        return answer;
    }
}