import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int lengthN;
  static int targetR;
  static int targetC;
  static int length;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    init();
    segmentation(targetR, targetC, length);
    System.out.println(answer);
  }

  public static void segmentation(int row, int col, int size) {
    if (size == 1) {
      return;
    }
    int mid = size / 2;
    if (row < mid && col < mid) {
      segmentation(row, col, mid);
    }
    if (row < mid && col >= mid) {
      answer += (mid * mid);
      segmentation(row, col - mid, mid);
    }
    if (row >= mid && col < mid) {
      answer += (mid * mid * 2);
      segmentation(row - mid, col, mid);
    }
    if (row >= mid && col >= mid) {
      answer += (mid * mid * 3);
      segmentation(row - mid, col - mid, mid);
    }
  }

  public static void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    lengthN = Integer.parseInt(st.nextToken());
    targetR = Integer.parseInt(st.nextToken());
    targetC = Integer.parseInt(st.nextToken());
    length = (int) Math.pow(2, lengthN);
  }

}
