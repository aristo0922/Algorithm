import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());

        arr = new int[numB];
        visit = new boolean[numA];
        dfs(numA, numB, 0);
        System.out.println(sb);
    }
    public static void dfs(int N, int M, int depth){
        if(depth== M){
            for(int val : arr){
                sb.append(val + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(!visit[i]){
                visit[i]=true;
                arr[depth] = i+1;
                dfs(N,M, depth+1);
                visit[i] = false;
            }
        }
    }

}
