import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> nums = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int A = Math.abs(a);
                int B = Math.abs(b);
                if (A > B)
                    return A - B;
                else if (A == B) {
                    if (a > b) return 1;
                    else return -1;
                } else return -1;
            }
        });

        for (int i = 0; i < size; i++) {
            int node = Integer.parseInt(br.readLine());
            if (node == 0) {
                if (nums.size() == 0) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(nums.poll());
                continue;
            }
            nums.offer(node);
        }
    }
}
