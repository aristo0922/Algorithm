import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    while(true){
      String command = br.readLine();
      if(command == null || command == "\n"){
        return;
      }
      st= new StringTokenizer(command);
      if(!st.hasMoreTokens()){
        return;
      }
      int size = Integer.parseInt(st.nextToken());
      size = (int)Math.pow(3, size);
      System.out.println(segmentation(size/3));
    }
  }

  public static String segmentation(int size){
    if(size == 0 ){
      return "-";
    }
    if(size != 1){
      String base = segmentation(size/3);
      StringBuilder sb = new StringBuilder();
      sb.append(base).append(blank(size)).append(base);
      return sb.toString();
    }

    return "- -";
  }

  public static String blank(int size){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i< size; i++){
      sb.append(" ");
    }
    return sb.toString();
  }

}
