import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
  static List<Integer> group = new LinkedList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] commands = br.readLine().split(" ");
    int size = Integer.parseInt(commands[0]);
    int step = Integer.parseInt(commands[1]);

    for(int i=1; i <= size ; i++){
      group.add(i);
    }

    System.out.println(solution(step));
  }

  static String solution(int step){
    int now = -1;

    now += step;
    int node = group.get(now);
    group.remove(now);
    sb.append("<").append(node);


    while(group.size() > 0){
      now += step - 1;
      while(now >= group.size()){
        now -= group.size();
      }
      node = group.get(now);
      sb.append(", "+node);
      group.remove(now);
    }

    sb.append(">");
    return sb.toString();
  }

}
