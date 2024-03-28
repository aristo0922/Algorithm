import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Node> queue = new ArrayDeque<>();

    public static class Node {
        String value;
        int index;

        Node(String v, int i) {
            this.value = v;
            this.index = i;
        }

        int getValue() {
            return Integer.parseInt(this.value);
        }

        Integer getIndex() {
            return this.index;
        }
    }
    public static StringBuffer doMethod(StringBuffer sb, int num){
        if(num > 0){
            for(int i=1;i<num;i++){
                queue.add(queue.pollFirst());
            }
            Node node = queue.pollFirst();
            sb = setBuffer(sb, node);
        }
        if(num<0){
            for(int i=0;i<num*-1 ; i++){
                queue.addFirst(queue.pollLast());
            }
            Node node = queue.pollFirst();
            sb = setBuffer(sb, node);
        }
        return sb;
    }
    public static StringBuffer setBuffer(StringBuffer sb, Node node){
        sb.append(node.getIndex()).append(" ");
        if(queue.size()!=0){
            sb = doMethod(sb, node.getValue());
        }
        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNum = Integer.parseInt(br.readLine());
        String[] arrs = br.readLine().split(" ");

        for (int i = 0; i < tryNum; i++) {
            Node node = new Node(arrs[i], i+1);
            queue.add(node);
        }
        StringBuffer sb = new StringBuffer();
        sb = doMethod(sb, 1);
        System.out.println(sb);

    }
}
