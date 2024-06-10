import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] command = br.readLine().split(" ");
        N = Integer.parseInt(command[0]);
        M = Integer.parseInt(command[1]);
        arr = new int[M];
        Answer(0);

        System.out.println(sb);
    }

    public static void Answer(int depth){
        if(depth == M){
            for(int node: arr){
                sb.append(node).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            arr[depth] = i;
            Answer(depth+1);
        }
    }
}
