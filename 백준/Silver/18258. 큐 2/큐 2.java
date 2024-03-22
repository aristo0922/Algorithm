import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tryNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < tryNum; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    queue.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    if (queue.peekFirst() == null) {
                        sb.append(-1).append('\n');
                        break;
                    }
                    sb.append(queue.pollFirst()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if (queue.peekFirst() == null) {
                        sb.append(1).append('\n');
                        break;
                    }
                    sb.append(0).append('\n');
                    break;
                case "front":
                    if (queue.peekFirst() == null) {
                        sb.append(-1).append('\n');
                        break;
                    }
                    sb.append(queue.peekFirst()).append('\n');
                    break;
                case "back":
                    if (queue.peekLast() == null) {
                        sb.append(-1).append('\n');
                        break;
                    }
                    sb.append(queue.peekLast()).append('\n');
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
