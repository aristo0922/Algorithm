import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int[] resource;
  public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());

    resource = new int[size];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < size; i++){
      resource[i]=Integer.parseInt(st.nextToken());
    }
    int answer = solution(size);
    System.out.println(answer);

  }

  public static int solution(int size){
    int[] sum = new int[size];

    int max = 0;
    for(int i =0 ; i < size; i++){
      sum[i] = resource[i];

      for(int j = 0; j < i; j++){
        if(resource[i] == resource[j]){
          sum[j] = sum[i] ;
          continue;
        }
        if(resource[j] < resource[i])
          sum[i] = sum[j] + resource[i] > sum[i] ? sum[j] + resource[i] : sum[i];
      }
      if (sum[i] > max) max = sum[i];
    }
    return max;
  }
}
