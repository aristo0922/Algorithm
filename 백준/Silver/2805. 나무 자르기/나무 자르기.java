import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[] treeL;

  public static void main(String[] args) throws IOException {
    String[] sizes = br.readLine().split(" ");
    int treeN = Integer.parseInt(sizes[0]);
    int totalM = Integer.parseInt(sizes[1]);

    treeL = new int[treeN];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int i = 0;
    int max = 0;
    while (st.hasMoreTokens()) {
      treeL[i] = Integer.parseInt(st.nextToken());
      if(treeL[i++] > max){
        max = treeL[i-1];
      }
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(solution(0, max, totalM));
    bw.flush();
  }

  public static String solution(int left, int right, int goal){
    int height =0;

    while(left < right){
      int mid = (left + right) /2;
      long total = vaildSize(mid, goal);
      
      if(total >= goal) left = mid + 1;
      else right = mid;
    }
    return String.valueOf(left-1);
  }

  public static long vaildSize(int height, int goal){
    long total = 0;
    for(int tree :treeL){
      if(tree > height){
        total += tree - height;
        if(total > goal) return goal +1;
      }
    }
    return total;
  }
}