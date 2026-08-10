class Solution {
    static int answer = 0;
    static int count = 0;

    public static int solution(String word) {

        answer = 0;
        count = 0;

        DFS(word, "");

        return answer;
    }

    public static void DFS(String word, String str) {

    	if (word.equals(str)) {
    	    answer = count;
    	    return;
    	} else {
    	    count++;
    	}

        // 길이 5면 더 못 내려감
        if (str.length() == 5) {
            return;
        }

        DFS(word, str + "A");
        if (answer != 0) return;

        DFS(word, str + "E");
        if (answer != 0) return;

        DFS(word, str + "I");
        if (answer != 0) return;

        DFS(word, str + "O");
        if (answer != 0) return;

        DFS(word, str + "U");
    }
}