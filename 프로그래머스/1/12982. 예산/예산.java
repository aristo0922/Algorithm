import java.util.*;

class Solution {
    public int solution(int[] d, int budget) { 
        int answer = 0;
        int sum = 0;
        
        Arrays.parallelSort(d);
        
        for(int n: d){
            if( sum + n <= budget){
                sum += n;
                answer++;
                continue;
            }
            break;
        }
        
        
        return answer;
    }
}