import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int length;
  static int[] preArr, inArr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    int tCase = Integer.parseInt(br.readLine());
    for (int i = 0; i < tCase; i++) {
      length = Integer.parseInt(br.readLine());
      setArrs(length);

      findPostArr(0, 0, length);
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }

  public static void findPostArr(int preRootIdx, int beginIn, int end) {
    if (preRootIdx >= length) {
      return;
    }
    int rootValue = preArr[preRootIdx];
//    int index=beginIn;

    for (int index = beginIn; index < end; index++) {
      if (rootValue == inArr[index]) {
        findPostArr(preRootIdx + 1, beginIn, index);
        findPostArr(preRootIdx + index + 1 - beginIn, index + 1, end);
        sb.append(rootValue + " ");
        return;
      }
    }

//    while(rootValue!= inArr[index]) index++;
//    findPostArr(preRootIdx+1, beginIn, index);
//    findPostArr(preRootIdx+index+1-beginIn, index+1, end);
//    sb.append(rootValue + " ");
  }

  public static void setArrs(int length) throws IOException {
    preArr = new int[length];
    inArr = new int[length];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < length; i++) {
      preArr[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < length; i++) {
      inArr[i] = Integer.parseInt(st.nextToken());
    }
  }
}
