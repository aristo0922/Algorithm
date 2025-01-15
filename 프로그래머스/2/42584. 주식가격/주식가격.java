import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
  public int[] solution(int[] prices) {
    int priceLen = prices.length;
    int[] answer = new int[priceLen];
    Queue<Integer> stocks = init(prices);

    while (stocks.isEmpty() != true) {
      int node = stocks.poll();
      int count = 0;
      if(stocks.size() == 0) break;
      for (int i = priceLen - stocks.size(); i < priceLen; i++) {
        count++;
        if (node > prices[i]) {
          answer[priceLen - stocks.size() - 1] = count;
          break;
        }
      }

      answer[priceLen - stocks.size() - 1] = count;
    }

    return answer;
  }

  public Queue<Integer> init(int[] prices) {
    Queue<Integer> stocks = new ArrayDeque<>();

    for (int price : prices) {
      stocks.add(price);
    }
    return stocks;
  }

}