class Solution {
    private static boolean isRelatedThree(int num){
        if (num % 3 == 0) return true;
        
        boolean result = false;

        char [] strNum = String.valueOf(num).toCharArray();
        
        for(char n: strNum){
            if (n == '3'){
                result = true;
                break;
            }
        }
        
        return result;
    }
    
    public int solution(int n) {
        int answer = 0;
        int now = 0;
        do {
            now +=1;
            answer += 1;
            while (isRelatedThree(answer) == true){
                answer+=1;
            }
            
        } while (now < n) ;
        return answer;
    }
}