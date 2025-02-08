class Solution {
    private static int maxIndex = -1;

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        maxIndex = board.length-1;
        String color = board[h][w];
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[] compare = new int[2];
        
        for(int i=0; i<4; i++){
            compare[0] = h + dx[i];
            compare[1] = w + dy[i];
            
            if(isIndex(compare) != true)
                continue;
            
            if(isSameColor(color, board[compare[0]][compare[1]]))
                answer++;
        }
        

        return answer;
    }
    
    private static boolean isIndex(int[] compare){
        if(compare[0] > maxIndex || compare[1] > maxIndex){
            return false;
        }
        if(compare[0] < 0 || compare[1] < 0){
            return false;
        }
        return true;
    }
    
    private static boolean isSameColor(String color, String compare){
        if(color.equals(compare)) return true;
        return false;
    }
}