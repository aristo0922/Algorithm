import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // size
        int S = Integer.parseInt(st.nextToken()); // target number
        int len = N+1; // answer
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int sum = 0;
        while (right < N) {
            while (right < N) {
                sum += arr[right++];
                if (sum >= S){
                    len = Math.min(len, right - left);
                    break;
                }
            }
            while (left < right && sum > S) {
                sum -= arr[left++];
                if (sum >= S)
                    len = Math.min(len, right - left);
            }
        }
        if(len == N+1){
            System.out.println(0);
        }
        else {
            System.out.println(len);
        }


    }
}
