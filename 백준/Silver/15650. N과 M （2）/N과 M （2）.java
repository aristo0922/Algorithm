import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr=new int[M];

        Backtracking(1, 0);

        System.out.println(sb);
    }

    public static void Backtracking(int at, int depth) {
        if(depth == M){
            for(int node: arr){
                sb.append(node+" ");
            }
            sb.append("\n");
            return;
        }
        for (int node = at; node <= N; node++) {
            arr[depth]=node;
            Backtracking(node+1, depth+1);
        }
    }
}
