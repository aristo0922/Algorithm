import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int childM, cookieN;
  static int[] cookieL;
  static int start = 1, end;

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    init();
    end = cookieL[cookieN - 1];

    int count = solution(start, end);
    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
  }

  static int result = 0;

  public static int solution(int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;
      int cnt = 0;
      for (int i = 0; i < cookieN; i++) {
        cnt += cookieL[i] / mid;
      }
      if (cnt >= childM) {
        if(result < mid)
          result = mid;
        start = mid + 1;
        continue;
      }
      end = mid - 1;
    }
    return result;
  }

  public static void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    childM = Integer.parseInt(st.nextToken());
    cookieN = Integer.parseInt(st.nextToken());
    cookieL = new int[cookieN];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < cookieN; i++) {
      cookieL[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(cookieL);
  }

}
