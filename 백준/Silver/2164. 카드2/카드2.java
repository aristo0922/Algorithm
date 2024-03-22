import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Integer> queue= new ArrayDeque<>();
    static void init(int n){
        for(int index=1; index<=n ; index++){
            queue.add(index);
        }
    }
    static void command(){
        do{
            queue.pollFirst();
            queue.add(queue.pollFirst());
        }while(queue.size()>2);
        queue.pollFirst();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNum = Integer.parseInt(br.readLine());
        if(tryNum!= 1 && tryNum != 2){
            init(tryNum);
            command();
            System.out.println(queue.pollFirst());
            return ;
        }
        System.out.println(tryNum);
    }
}
