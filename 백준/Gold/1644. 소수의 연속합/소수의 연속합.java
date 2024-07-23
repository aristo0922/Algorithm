import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static List<Integer> selfNums = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    init(N);

    System.out.println(search(N));
  }

  public static void init(int N) {
    int[] nums = new int[N + 1];

    for (int i = 2; i < N + 1; i++) {
      for (int j = i; j * i < N + 1 && i * j > 0; j++) {
        nums[i * j]++;
      }
      if (nums[i] == 0) {
        selfNums.add(i);
      }
    }
  }

  public static int search(int N) {
    int l = 0, r = 0;
    int answer = 0, sum = 0;
    int size = selfNums.size();
    while (l <= r && r <= size) {
      if (sum == N) {
        answer++;
      }
      if (sum <= N) {
        if (r == size) {
          return answer;
        }
        sum += selfNums.get(r++);
        continue;
      }
      if (sum > N) {
        sum -= selfNums.get(l++);
      }
    }
    return answer;
  }
}
