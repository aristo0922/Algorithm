class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int size = common.length;
        if(isPlus(common,0) == true){
            int step = common[2] - common[1];
            answer= common[size-1] +step;
            return answer;
        }
        int step = common[2]/common[1];
        answer = common[size-1]* step;
        return answer;
    }
    
    public static boolean isPlus(int[] common, int leftIndex){
        int size = common.length;
        if(leftIndex+2 >= size) return true;
        int n1 = common[leftIndex]- common[leftIndex+1];
        int n2 = common[leftIndex+1] - common[leftIndex+2];
        if(n1 == n2){
            return isPlus(common, leftIndex+1);
        }
        return false;
    }
    
    
}