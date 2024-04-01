class Solution {
   public int[] solution(int[] sequence, int k) {
        int SIZE = sequence.length;
        int left = 0 , right = SIZE;
       int sum = 0;
       for (int L = 0, R = 0 ; L<SIZE; L++){
           while(R<SIZE && sum < k){
               sum += sequence[R++];
           }
           if(sum == k){
               int range = R - L -1;
               if((right - left) > range){
                   left = L;
                   right = R-1;
               }
           }
           sum -= sequence[L];
       }
       int [] answer = {left, right};
        return answer;
    }
}