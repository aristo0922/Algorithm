import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] values = br.readLine().split(" ");
        int N = Integer.parseInt(values[0]);
        int M = Integer.parseInt(values[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for(int i =0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int start = 0 , end=0;
        int sum = 0;
        while(end < N){
            if(sum < M){
                sum += nums[end++];
            }
            if(sum > M){
                sum -= nums[start++];
            }
            if(sum == M){
                answer +=1;
                sum -= nums[start++];
            }
        }

        System.out.println(answer);

        br.close();
    }
}
