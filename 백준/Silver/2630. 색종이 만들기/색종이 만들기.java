import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

public class Main {

  static int[][] paper;
  static int size;
  static int white = 0, blue = 0;

  public static void main(String[] args) throws IOException {
    init();
    segmentation(0, 0, size);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(white + "\n" + blue);
    bw.flush();
  }

  public static boolean isSame(int low, int col, int color) {
    if (paper[low][col] == color) {
      return true;
    }
    return false;
  }

  public static boolean isPaper(int low, int col, int size) {
    int color = paper[low][col];
    for (int i = low; i < low + size; i++) {
      for (int j = col; j < col + size; j++) {
        if (color != paper[i][j]) {
          return false;
        }
      }
    }

    return true;
  }

  // true: 1-blue, false: 0-white
  public static void segmentation(int low, int col, int size) {
    if (isPaper(low, col, size) != true) {
      int newSize = size / 2;
      segmentation(low, col, newSize);
      segmentation(low + newSize, col, newSize);
      segmentation(low, col + newSize, newSize);
      segmentation(low + newSize, col + newSize, newSize);
      return;
    }
    if (paper[low][col] == 1) {
      blue++;
    }
    if (paper[low][col] == 0) {
      white++;
    }

  }

  public static void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    size = Integer.parseInt(br.readLine());
    paper = new int[size][size];

    for (int i = 0; i < size; i++) {
      String[] nodes = br.readLine().split(" ");
      for (int j = 0; j < size; j++) {
        paper[i][j] = Integer.parseInt(nodes[j]);
      }
    }
  }

}
