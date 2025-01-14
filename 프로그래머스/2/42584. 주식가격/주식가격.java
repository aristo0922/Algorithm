import java.util.Stack;


class Solution {
    
  public int[] solution(int[] prices){
    int len = prices.length;
    int[] ans = new int [len];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i< len; i++){
      while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
        int idx = stack.pop();
        ans[idx] = i - idx;
      }
      stack.push(i);
    }

    while(!stack.isEmpty()){
      int idx = stack.pop();
      ans[idx] = len -1 -idx;
    }

    return ans;
  }

}