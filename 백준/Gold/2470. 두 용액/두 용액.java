import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int sum = arr[left] + arr[right];
        double standard = Math.abs(sum);
        while (left < right) {
            sum = arr[left] + arr[right];
            if (standard >= Math.abs(sum)) {
                standard = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }
            if (sum <= 0) {
                left++;
                continue;
            }
            if (sum > 0) {
                right--;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(String.valueOf(answer[0])).append(" ").append(String.valueOf(answer[1]));
        bw.flush();
        bw.close();
    }
}
