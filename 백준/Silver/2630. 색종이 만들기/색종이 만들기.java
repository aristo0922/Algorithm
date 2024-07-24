import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static int[][] paper;
  private static int size;
  private static int white = 0, blue = 0;

  public static void main(String[] args) throws IOException {
    init();

    partitions(0, 0, size);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(white + "\n" + blue);
    bw.flush();
  }

  public static int partitions(int row, int col, int size) {
    if (checkColor(row, col, size)) {
      if (paper[row][col] == 0) {
        return white++;
      }
      return blue++;
    }
    int newSize = size / 2;
    partitions(row, col, newSize);
    partitions(row, col + newSize, newSize);
    partitions(row + newSize, col, newSize);
    return partitions(row + newSize, col + newSize, newSize);
  }

  public static boolean checkColor(int row, int col, int size) {
    int color = paper[row][col];
    for (int i = row; i < row + size; i++) {
      for (int j = col; j < col + size; j++) {
        if (paper[i][j] != color) {
          return false;
        }
      }
    }
    return true;
  }

  public static void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    size = Integer.parseInt(br.readLine());
    paper = new int[size][size];
    for (int i = 0; i < size; i++) {
      String[] colors = br.readLine().split(" ");
      for (int j = 0; j < size; j++) {
        paper[i][j] = Integer.parseInt(colors[j]);
      }
    }
  }

}
