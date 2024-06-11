import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int count=0;
        for (int i = 0; i < size; i++) {
            int node = Integer.parseInt(br.readLine());
            pq.add(node);
            if(node==0) {
                System.out.println(pq.poll());
            }
        }
    }
}
