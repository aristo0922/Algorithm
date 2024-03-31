import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Integer> queueScore = new ArrayDeque<>();
    static Deque<Integer> queueTimer = new ArrayDeque<>();
    static int total = 0;

    static void doCommand(){
        int timer = queueTimer.pollLast() -1;
        if(timer>0){
            queueTimer.add(timer);
            return;
        }
        if(timer==0){
            total += queueScore.pollLast();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int LIMIT = Integer.parseInt(br.readLine());

        for (int i = 0; i < LIMIT; i++){
            String[] commands = br.readLine().split(" ");
            if(commands.length>2){
                queueScore.add(Integer.parseInt(commands[1]));
                queueTimer.add(Integer.parseInt(commands[2]));
            }
            if(queueTimer.size()>0){
                doCommand();
            }
        }
        System.out.println(total);

    }
}
