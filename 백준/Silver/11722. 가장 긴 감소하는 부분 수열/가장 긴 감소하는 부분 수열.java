import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] resource;
  static int[] decrease;
  static int depth = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    resource = new int[size];
    decrease = new int[size];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < size; i++) {
      resource[i] = Integer.parseInt(st.nextToken());
    }
    solution(size);
    System.out.println(depth);

  }
  public static void solution(int size){
    for(int i = 0; i < size; i++){
      if(isInsertLast(resource[i])){
        continue;
      }
      manageDecrease(resource[i]);
    }
  }

  public static void manageDecrease(int node){
    int left = 0, right = depth-1;
    while(left < right){
      int mid = (left + right) / 2;
      if(decrease[mid] > node){
        left = mid+1;
        continue;
      }
      right = mid;
    }
    decrease[left] = node;
  }


  public static boolean isInsertLast(int node){
    if(depth == 0){
      decrease[depth++] = node;
      return true;
    }
    if(decrease[0] <= node){
      decrease[0] = node;
      return true;
    }
    if(decrease[depth-1] > node){
      decrease[depth++] = node;
      return true;
    }

    return false;
  }



}
