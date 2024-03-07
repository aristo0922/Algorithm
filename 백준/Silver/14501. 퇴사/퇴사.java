import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int result;
    static int[][] schedules;

    public static int[][] getSchedules() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        schedules = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] timePay = br.readLine().split(" ");
            schedules[i][0] = Integer.valueOf(timePay[0]);
//            schedules[i][0] = Integer.parseInt(stringtokernizer.nextToken());
            schedules[i][1] = isValid(i, timePay);
        }
        return schedules;
    }

    public static int isValid(int index, String[] pay) {
        if (index + Integer.valueOf(pay[0]) > N) return 0;
        return Integer.valueOf(pay[1]);
    }

    public static void calcPay(int idx, int pay) {
        if (idx >= N) {
            result = Math.max(pay, result);
            return;
        }

        if (idx + schedules[idx][0] <= N) {
            calcPay(idx + schedules[idx][0], pay + schedules[idx][1]);
        } else {
            calcPay(idx + schedules[idx][0], pay);
        }
        calcPay(idx+1, pay);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        schedules = getSchedules();
        result = 0;
        calcPay(0,0);
        System.out.println(result);

    }
}
