import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Node {
    int value;
    int index;

    Node(String v, int i) {
        this.value = Integer.parseInt(v);
        this.index = i;
    }

    Node(int v, int i) {
        this.value = v;
        this.index = i;
    }
}

public class Main {
    static ArrayList<Integer> heights = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNum = Integer.parseInt(br.readLine());
        int[] answer = new int[tryNum];
        String[] nodes = br.readLine().split(" ");

        Deque<Node> queue = new ArrayDeque<>();
        Node node = new Node(nodes[nodes.length - 1], nodes.length - 1);
        queue.add(node);

        for (int i = nodes.length - 2; i >= 0; i--) {
            int num = Integer.parseInt((nodes[i]));
            do {
                if (num >= queue.peekLast().value) {
                    answer[queue.pollLast().index] = i+1;
                    continue;
                }
                break;
            } while (queue.size()>0);
            queue.add(new Node(num, i));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < tryNum; i++) {
            try{
                sb.append(answer[i]).append(" ");
            }catch (NullPointerException e){
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);

    }
}
