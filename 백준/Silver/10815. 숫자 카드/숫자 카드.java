import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<String> set = new HashSet<>(N);

        for (int i = 0; i < N; i++) {
            if (st.hasMoreElements()) {
                set.add(st.nextToken());
            }
        }

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String node;
        for (int i = 0; i < n; i++) {
            if (!st.hasMoreElements()) {
                break;
            }
            node = st.nextToken();
            if (set.contains(node)) {
                sb.append("1" + " ");
                continue;
            }
            sb.append("0" + " ");
        }

        System.out.println(sb);


    }
}
