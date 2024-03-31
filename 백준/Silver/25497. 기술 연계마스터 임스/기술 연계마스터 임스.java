import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Character> queueS = new ArrayDeque<>();
    static Deque<Character> queueL = new ArrayDeque<>();

    static int getCount(String commands) {
        int count = 0;
        for (int i = 0; i < commands.length(); i++) {
            char node = commands.charAt(i);
            switch (node) {
                case 'S':
                    queueS.add(node);
                    break;
                case 'K':
                    if(queueS.size() <= 0){
                        return count;
                    }
                    queueS.poll();
                    count +=1;
                    break;
                case 'L':
                    queueL.add(node);
                    break;
                case 'R':
                    if(queueL.size() <= 0){
                        return count;
                    }
                    queueL.poll();
                    count+=1;
                    break;
                default:
                    count += 1;
            }
        }
        return count;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNum = Integer.parseInt(br.readLine());

        String commands = br.readLine();
        System.out.println(getCount(commands));

    }
}
