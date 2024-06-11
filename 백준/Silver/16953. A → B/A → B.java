import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long from, to;
    static long ANSWER = Integer.MAX_VALUE;

    static void setNums() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] nums = br.readLine().split(" ");
            from = Integer.parseInt(nums[0]);
            to = Integer.parseInt(nums[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        setNums();
        ANSWER = Answer(from, to, 1);
        if (ANSWER == Integer.MAX_VALUE) {
            ANSWER = -1;
        }
        System.out.println(ANSWER);
    }

    static long Answer(long at, long Target, long count) {
        if (at > Target) return Integer.MAX_VALUE;

        if (at == Target) {
            return count;
        }

        if (at * 2 == Target || 10 * at + 1 == Target) {
            return Math.min(ANSWER, count + 1);
        }

        long min1 = Answer(at * 2, Target, count + 1);
        long min2 = Answer(10 * at + 1, Target, count + 1);

        return Math.min(min1, min2);
    }
}
