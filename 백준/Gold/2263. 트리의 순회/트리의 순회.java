import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.BinaryOperator;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] inOrder, postOrder;
  static int size;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    set();
    findPreOrder(0, size - 1, 0, size - 1);
    System.out.println(sb.toString());
  }

  public static void findPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
      return;
    }
    int root = postOrder[postEnd];
    sb.append(root).append(" ");
    int index = 0;
    while (index < inEnd) {
      if (inOrder[index] == root) {
        break;
      }
      index++;
    }
    int length = index - inStart;
    findPreOrder(inStart, index - 1, postStart, postStart + length - 1);
    findPreOrder(index + 1, inEnd, postStart+length, postEnd - 1);
  }

  public static void set() throws IOException {
    size = Integer.parseInt(br.readLine());

    inOrder = new int[size];
    postOrder = new int[size];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < size; i++) {
      inOrder[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < size; i++) {
      postOrder[i] = Integer.parseInt(st.nextToken());
    }
  }

}
