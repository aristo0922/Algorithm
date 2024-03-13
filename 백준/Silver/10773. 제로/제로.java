import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> stack = new ArrayList<>();

    static void process(int n) {
        if (n == 0) {
            stack.remove(stack.size() - 1);
            return;
        }
        stack.add(n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNum = Integer.valueOf(br.readLine());
        for (int index = 0; index < tryNum; index++) {
            int Num = Integer.valueOf(br.readLine());
            process(Num);
        }
        int answer = 0;
        if (stack.size() != 0) {
            for (int num : stack) {
                answer += num;
            }
        }
        System.out.println(answer);

    }
}
