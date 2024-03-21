import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int state = 1;
    static Deque<Integer> queue = new ArrayDeque<>();
    static Deque<Integer> subQueue = new ArrayDeque<>();

    static int setQueue() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int people = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            for (int index = 0; index < people; index++) {
                queue.add(Integer.parseInt(line[index]));
            }
            return people;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    static void doCommand(int custom) {
        do {
            if (queue.size() == 0 && subQueue.size() == 0) break;
            if (queue.size() == 0 && subQueue.peekLast() != state) {
                System.out.println("Sad");
                return;
            }
            if (subQueue.size() != 0) {
                state = subQueCommand(state);
            }
            if (queue.size() != 0) {
                state = queCommand(state);
            }
        } while (state <= custom);
        System.out.println("Nice");
    }

    static int queCommand(int state) {
        if (queue.peek() == state) {
            queue.poll();
            state += 1;
            return state;
        }
        if(subQueue.size()>0 && subQueue.peekLast()==state){
            return state;
        }
        subQueue.add(queue.poll());
        return state;
    }

    static int subQueCommand(int state) {
        if (subQueue.peekLast() == state) {
            subQueue.pollLast();
            state += 1;
        }
        return state;
    }

    public static void main(String[] args) {
        int custom = setQueue();
        doCommand(custom);
    }
}
