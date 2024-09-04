import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] increase, decrease, origin;
  static int size;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    size = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    increase = new int[size];
    decrease = new int[size];
    origin = new int[size];

    for (int i = 0; i < size; i++) {
      origin[i] = Integer.parseInt(st.nextToken());
    }
    int answer = 0;

    // get increasing
    for(int i= 0; i < size; i++){
      increase[i]=1;
      for(int j = 0; j < i; j++){
        if(origin[i] > origin[j] && increase[i] <= increase[j]){
          increase[i] = increase[j] + 1;
        }
      }
    }

    for(int i = size-1; i >= 0; i--){
      decrease[i] = 1;

      for(int j = size-1 ; j >= 0; j--){
        if(origin[i] > origin[j] && decrease[i] <= decrease[j]){
          decrease[i] = decrease[j] + 1;
        }
      }
    }

    for(int i = 0; i< size; i++){
      int sum = increase[i] + decrease[i] - 1;
      answer = Math.max(sum, answer);
    }


    System.out.println(answer);

  }

}
