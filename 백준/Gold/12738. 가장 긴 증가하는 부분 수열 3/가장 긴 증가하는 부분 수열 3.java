import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[] increase;
  static int depth = 0;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int size = Integer.parseInt(br.readLine());
    increase = new int[size];

    StringTokenizer st = new StringTokenizer(br.readLine());
    int node;
    for(int i = 0; i < size ; i++){
      node = Integer.parseInt(st.nextToken());
      if(insertNode(node)) continue;
      increase[findPosition(node)] = node;
    }

    bw.write(String.valueOf(depth));
    bw.flush();
  }

  public static int findPosition(int node){
    int lower = 0, upper = depth-1;
    while(lower < upper){
      int mid = (lower + upper) / 2;
      if(increase[mid] >= node){
        upper = mid;
        continue;
      }
      lower = mid+1;
    }
    return lower;
  }

  public static boolean insertNode(int node){
    if(depth == 0){
      increase[depth++] = node;
      return true;
    }

    if(increase[0] > node){
      increase[0] = node;
      return true;
    }

    if(increase[depth-1] < node){
      increase[depth++] = node;
      return true;
    }
    return false;
  }

}
