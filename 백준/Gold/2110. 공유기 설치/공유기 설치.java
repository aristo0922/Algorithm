import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int[] houses;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] options = br.readLine().split(" ");
    int houseN = Integer.parseInt(options[0]);
    int wifiN = Integer.parseInt(options[1]);
    houses = new int[houseN];

    for (int i = 0; i < houseN; i++) {
      houses[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(houses);

    solution(wifiN);
  }

  public static void solution(int nums) {
    int count = 0;
    int left = 1;
    int right = houses[houses.length - 1] - houses[0] + 1;
    int max = 0;

    while (left < right) {
      int mid = (left + right) / 2;
      count = getCount(mid);

      if (count < nums) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    System.out.println(left-1);
  }

  public static int getCount(int len) {
    // size 만큼 와이파이 설치 가능한 지 확인
    if (len == 1) {
      return houses.length;
    }
    int LEN = houses.length;
    int before = houses[0];
    int count = 1;

    for (int i = 1; i < LEN; i++) {
      int next = houses[i];
      if (next - before < len) {
        continue;
      }
      count++;
      before = next;
    }
    return count;
  }

}
