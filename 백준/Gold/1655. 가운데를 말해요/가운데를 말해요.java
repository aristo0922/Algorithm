import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(num);
                if(!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()){
                    int minN = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minN);
                }
            } else {
                minHeap.add(num);
                if(minHeap.peek() < maxHeap.peek()){
                    int minN = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minN);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
