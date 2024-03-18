import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static Deque<Character> deque = new ArrayDeque<>();
    static int answer = 0;
    static char before;

    public static void addStick(char stick) {
        deque.add(stick);
        before = stick;
    }

    public static void popStick(char stick) {
        if (before == ')') {
            answer += 1;
            deque.pop();
        }
        if (before == '(') {
            deque.pop();
            before = stick;
            answer += deque.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();

        for (char input : inputs) {
            if (input == '(') {
                addStick(input);
                continue;
            }
            if (input == ')') {
                popStick(input);
            }
        }
        System.out.println(answer);
    }
}
