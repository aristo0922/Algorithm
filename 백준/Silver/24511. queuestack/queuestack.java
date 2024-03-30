import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNum = Integer.parseInt(br.readLine());
        String[] types = br.readLine().split(" ");
        String[] values = br.readLine().split(" ");

        Deque<String> queue = new ArrayDeque<>();
        for(int index=0; index< tryNum ; index++){
            if(types[index].equals("0")){//queue  인 경우
                queue.add(values[index]);
            }
        }

        int num = Integer.parseInt(br.readLine());
        String[] addNums = br.readLine().split(" ");
        for(String addNum : addNums){
            queue.addFirst(addNum);
        }

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<num;i++){
            sb.append(queue.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}
