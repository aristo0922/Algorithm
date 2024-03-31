import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int SIZE = Integer.parseInt(br.readLine());
        String commands = br.readLine();
        Double[] values = new Double[SIZE];
        Deque<Double> queue = new ArrayDeque<>();

        for(int i=0;i<SIZE;i++){
            values[i]=Double.valueOf(br.readLine());
        }

        for (int i = 0; i < commands.length(); i++) {
            char node = commands.charAt(i);

            if (node == '+') {
                double num = queue.pollLast();
                double target = queue.pollLast();
                queue.add(target+num);
                continue;
            }
            if (node == '-') {
                double num = queue.pollLast();
                double target = queue.pollLast();
                queue.add(target-num);
                continue;
            }
            if (node == '*') {
                double num = queue.pollLast();
                double target = queue.pollLast();
                queue.add(target*num);
                continue;
            }
            if (node == '/') {
                double num = queue.pollLast();
                double target = queue.pollLast();
                queue.add(target/num);
                continue;
            }
            queue.add(values[node - 'A']);
        }
        System.out.println(String.format("%.2f", queue.poll()));
    }
}
