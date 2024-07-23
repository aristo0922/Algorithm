import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static List<Integer> nums = new ArrayList<>();
  private static int TARGET = 0;
  private static int left, right;
  private static int answerLeft, answerRight;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    String[] inputs = br.readLine().split(" ");

    for (String num : inputs) {
      nums.add(Integer.parseInt(num));
    }

    left = 0;
    right = size - 1;
    int answer = Integer.MAX_VALUE;

    while (left < right) {
      int sum = nums.get(left) + nums.get(right);
      answer = compareValue(sum, answer);
    }

    StringBuilder sb= new StringBuilder();
    sb.append(nums.get(answerLeft)).append(" ").append(nums.get(answerRight));
    System.out.println(sb);
  }

  public static int compareValue(int value, int answer) {
    if(nums.get(left) == 0 && nums.get(right) == 0){
      return answer;
    }
    if(Math.abs(value)< Math.abs(answer)){
      answer = value;
      answerLeft = left;
      answerRight = right;
    }

    movePoint(value);
    return answer;
  }

  public static void movePoint(int value) {
    if (value < 0) {
      left++;
      return;
    }
    right--;
  }

}
