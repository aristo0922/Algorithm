import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int size;
  static int[] resource, answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    size = Integer.parseInt(br.readLine());
    resource = initSource(br.readLine());
    answer = new int[size];

    System.out.println(solution());
  }

  public static int solution(){
    int depth = 0;
    for(int i = 0; i < size; i++){
      depth = findPosition(resource[i], depth);
    }
    return depth;
  }

  public static int findPosition(int node, int depth){
    if(depth == 0){
      answer[0] = node;
      return ++depth;
    }
    if(node <= answer[0]){
      answer[0] = node;
      return depth;
    }
    if(node > answer[depth-1]){
      answer[depth] = node;
      return ++depth;
    }
    int low = 1;
    int high = depth-1;
    while(low < high){
      int mid = (low + high) / 2;
      if(answer[mid] == node)
        return depth;
      if(answer[mid] > node){
        high = mid;
        continue;
      }
      low = mid+1;
    }
    answer[low] = node;
    return depth;
  }

  public static int[] initSource(String line){
    StringTokenizer st = new StringTokenizer(line);
    resource = new int[size];
    for(int i =0 ; i < size ; i++){
      resource[i]= Integer.parseInt(st.nextToken());
    }
    return resource;
  }

}
