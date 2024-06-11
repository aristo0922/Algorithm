import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long num=0;
        while(pq.size() > 1){
            long add1 = pq.poll();
            long add2 = pq.poll();

            num+= add1 + add2;
            pq.add(add1+add2);
        }
        System.out.println(num);
    }
}
