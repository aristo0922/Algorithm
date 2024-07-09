import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine().replace("(\n|\r|\r\n|\n\r)", "");
    boolean isOne = line.charAt(0) == '0' ? false : true;
    int countZero = isOne == false ? 1 : 0;
    int countOne = isOne == true ? 1 : 0;

    for (int i = 1; i < line.length(); i++) {
      char node = line.charAt(i);
      if (isOne == false && node == '1') {
        countOne++;
        isOne = true;
        continue;
      }

      if (isOne == true && node == '0') {
        countZero++;
        isOne = false;
      }
    }

    int answer = countZero < countOne ? countZero : countOne;
    System.out.println(answer);

  }
}
