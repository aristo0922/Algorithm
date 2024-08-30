import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int[] depths;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    depths = new int[size];
    int answer = 0;

    int[] arrs = new int[size];
    for(int index = 0; index < size; index++){
      arrs[index] = Integer.parseInt(st.nextToken());
    }
    for(int index = 0; index < size; index++){
      answer = search(arrs[index], answer);
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(String.valueOf(answer));
    bw.flush();
  }

  public static int search(int num, int size) {
    int left = 0, right = size;

    if (size == 0 ) {
      depths[0]= num ;
      size++;
      return size;
    }
    if(depths[right - 1] < num){
      depths[right] = num;
      size++;
      return size;
    }

    if(depths[0] >= num){
      depths[0]= num;
      return size;
    }

    while (left < right) {
      int mid = (left + right) / 2;
      int compare = depths[mid];
      if (compare < num ) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    depths[left] = num;
    return size;
  }
}
