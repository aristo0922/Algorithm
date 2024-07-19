import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static int[] arr;
  public static int sum = 0;
  static List<Integer> selfNumArr = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int target = (Integer.parseInt(br.readLine()));
    arr = new int[target + 1];

    int index = 2;
    do {
      selfNumArr.add(index);
      setArr(index, target);
      index = nextSelfNum(index+1, target);
    } while (index <= target && index >= 0);

    int left = 0;
    int right = 0;
    int count = 0;
    do {
      if (sum < target) {
        if(right >= selfNumArr.size()){
          break;
        }
        sum = moveRight(sum, right);
        right += 1;
        continue;
      }
      if (sum > target) {
        sum = moveLeft(sum, left);
        left += 1;
        continue;
      }
      if(sum == target){
        count += 1;
        sum = moveLeft(sum, left);
        left += 1;
      }
    } while (left < right);

    System.out.println(count);
  }

  public static int moveRight(int sum, int indexR){
    return sum + selfNumArr.get(indexR);
  }

  public static int moveLeft(int sum, int indexL){
    return sum - selfNumArr.get(indexL);
  }

  public static int nextSelfNum(int num, int target) {
    if(num > target){
      return -1;
    }
    if (arr[num] > 0) {
      return nextSelfNum(num + 1, target);
    }
    return num;
  }

  public static void setArr(int num, int target) {
    for (int i = num; i <= target/num ; i++) {
      arr[num * i] += 1;
    }
  }
}
