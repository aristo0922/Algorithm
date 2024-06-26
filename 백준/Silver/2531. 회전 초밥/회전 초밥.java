import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//      회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        int[] eating = new int[d + 1];

        eating[c] = 1;
        int count = 1;

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            int sushiId = sushi[i];
            if (eating[sushiId] == 0){
                count ++;
            }
            eating[sushiId]++;
        }
        int max = count;
        
        for(int i = 0 ; i< N ; i++){
            int s_id = sushi[i];
            int e_id = sushi[i+k < N ? i+k : (i+k) % N];
            if(--eating[s_id]==0)
                count--;
            if(++eating[e_id] == 1)
                count++;
            max = Math.max(max, count);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();


    }
}
