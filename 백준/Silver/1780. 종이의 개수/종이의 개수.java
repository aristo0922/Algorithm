import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int length;
  private static int[][] table;
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int answer1 = 0, answer2 = 0, answer3 = 0;

  public static void main(String[] args) throws IOException {
    init();
    maincontrol(0, 0, length);
    System.out.println(answer1);
    System.out.println(answer2);
    System.out.println(answer3);
  }

  public static void maincontrol(int row, int col, int size) {
    if (row >= length || col >= length) {
      return;
    }
    if (!checkColor(row, col, size)) {
      segmentation(row, col, size);
    }
  }

  public static void segmentation(int row, int col, int size) {
    size = size / 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        maincontrol(row + size * i, col + size * j, size);
      }
    }
  }

  public static boolean checkColor(int row, int col, int size) {
    int type = table[row][col];
    int lastRow = row+size;
    int lastColumn = col+size;
    for (int i = row; i < lastRow; i++) {
      for (int j = col; j < lastColumn; j++) {
        if (type != table[i][j]) {
          return false;
        }
      }
    }
    if (type == -1) {
      answer1++;
    }
    else if (type == 0) {
      answer2++;
    }
    else if(type == 1) {
      answer3++;
    }
    return true;
  }

  public static void init() throws IOException {
    length = Integer.parseInt(br.readLine());
    table = new int[length][length];
    for (int i = 0; i < length; i++) {
      setTable(i);
    }
  }

  public static void setTable(int row) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int j = 0; j < length; j++) {
      table[row][j] = Integer.parseInt(st.nextToken());
    }
  }
}
