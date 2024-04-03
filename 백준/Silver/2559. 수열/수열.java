import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        int N = Integer.parseInt(inputStr[0]);
        int M = Integer.parseInt(inputStr[1]);
        int [] arrs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrs[i]=Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i=0;i<M;i++){
            result +=arrs[i];
        }
        int max = result;
        int start = 0, end = M;

        while (end < N) {
            result -= arrs[start++];
            result += arrs[end++];
            if(result > max){
                max = result;
            }
        }

        System.out.println(max);
    }
}
