import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static int[] requests;
  private static int max = 0, sum = 0, budget;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int countryN = Integer.parseInt(br.readLine());
    requests = new int[countryN];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < countryN; i++) {
      requests[i] = Integer.parseInt(st.nextToken());
      sum += requests[i];
      if (max < requests[i]) max = requests[i];
    }
    budget = Integer.parseInt(br.readLine());

    if (sum <= budget) {
      System.out.println(max);
    } else {
      int min = 0;
      solution(min, max);
    }
  }

  public static void solution(int left, int right) {
    int cost =0;
    while (left < right) {
      int mid = (left + right) / 2;
      if(mid >= budget){
        right = mid;
        continue;
      }
      cost = getSum(mid);
      if (cost > budget) {
        right = mid;
      } else { // cost < budget
        left = mid + 1;
      }
    }
    System.out.println(left-1);
  }

  public static int getSum(int maxCost) {
    int downSum = 0;

    for (int cost : requests) {
      if (cost <= maxCost) {
        downSum += cost;
      } else {
        downSum += maxCost;
      }
    }
    return downSum;
  }

}
