import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] toy = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            toy[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int min = N + 1;

        int right = 0, left = 0;

        while (right < N) {
            while(right < N && count < K){
                if(toy[right++]==1) count++;
            }
            if (count == K) {
                min = Math.min(min, right-left);
            }
            while(left < right){
                if(toy[left++] ==1) {
                    count--;
                    if(count +1 == K) min = Math.min(min, right - left +1);
                    break;
                }
            }
        }

        if(min == N+1){
            System.out.println(-1);
        }
        else{
            System.out.println(min);
        }

    }
}
