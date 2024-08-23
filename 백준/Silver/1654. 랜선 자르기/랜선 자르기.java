import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int[] lens;
  static long answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int lenN = Integer.parseInt(st.nextToken());
    int needN = Integer.parseInt(st.nextToken());
    lens = new int[lenN];
    int max = Integer.MIN_VALUE;

    for (int loop = 0; loop < lenN; loop++) {
      lens[loop] = Integer.parseInt(br.readLine());
      if (max < lens[loop]) {
        max = lens[loop];
      }
    }

    if (needN == 1 && lenN == 1) {
      answer = lens[0];
    }
    else solution(1, max, needN);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(answer));
    bw.flush();
  }

  public static void solution(long min, long max, int needs) {
    long mid = 0;
    while (min <= max) {
      mid = (max + min) / 2;
      long counts = segments(mid);

      if (needs > counts) {
        max = mid - 1;
      } else {
        min = mid + 1;
        if (answer < mid) {
          answer = mid;
        }
      }
    }
  }

  public static long segments(long len) {
    long sum = 0;
    for (int loop = 0; loop < lens.length; loop++) {
      sum += lens[loop] / len;
    }
    return sum;
  }
}
