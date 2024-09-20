import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  static int[][] table;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    int size = (int) Math.pow(2, K);
    table = new int[size][size];

    String[] inputs = br.readLine().split(" ");
    int y = Integer.parseInt(inputs[0]);
    int x = Integer.parseInt(inputs[1]);

    checkHole(x, y);
    if(size > 2){
      others();
    }
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for(int i = size-1; i>= 0; i--){
      int[] arr = table[i];
      for(int node: arr){
        bw.write(String.valueOf(node)+" ");
      }
      bw.write("\n");
    }

    bw.flush();
    bw.close();
  }

  public static void others(){
    int[] arrX = {1, 2};
    int[] arrY = {1, 2};
    int num = 3;

    for(int i = 0; i < 2; i++){
      for(int j = 0; j < 2; j++){
        int x = arrX[i];
        int y = arrY[j];
        if(table[x][y] == 0){
          table[x][y] = 2;
          setFloor(num++, x+1, y+1);
        }
      }
    }
  }

  public static void checkHole(int x, int y) {
    table[x-1][y-1] = -1;
    setFloor(1, x, y);
  }

  public static void setFloor(int tileN, int a, int b){
    int startx = a > 2 ? 2 : 0;
    int starty = b > 2 ? 2 : 0;

    for (int i = startx; i < startx + 2; i++) {
      for(int j = starty; j < starty+2; j++){
        if(table[i][j] == 0){
          table[i][j] = tileN;
        }
      }
    }
  }

}
