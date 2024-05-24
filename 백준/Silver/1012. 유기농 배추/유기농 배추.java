import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
// 그 다음 줄부터 각각의 테스트 케이스에 대해
// 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
// 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다.
// 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.
// 두 배추의 위치가 같은 경우는 없다.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<Integer[]> table;
    static int M; // ㄱㅏ로
    static int N;//세로
    static int K;// 배추가 심긴 갯수
    static boolean flag;
    static int answer;

    public static void getStaticValues() {
        table = new ArrayList<>();
        String[] commands = null;
        flag = false;
        answer = 0;
        try {
            commands = br.readLine().split(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        M = Integer.parseInt(commands[0]); // ㄱㅏ로
        N = Integer.parseInt(commands[1]);//세로
        K = Integer.parseInt(commands[2]);// 배추가 심긴 갯수
    }

    public static void initTable() {
        for (int i = 0; i < M; i++) {
            table.add(new Integer[N]);
        }

        for (int i = 0; i < K; i++) {
            String[] commands = null;

            try {
                commands = br.readLine().split(" ");
            } catch (Exception e) {
                e.printStackTrace();
            }

            int m = Integer.parseInt(commands[0]);
            int n = Integer.parseInt(commands[1]);
            table.get(m)[n] = 1;
        }
    }

    public static void controller() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                flag = false;
                move(i, j);
                if (flag == true) answer++;
            }
        }
        System.out.println(answer);
    }

    public static void DFS(int x, int y) {
        table.get(x)[y] = 2;
        move(x + 1, y);
        move(x - 1, y);
        move(x, y + 1);
        move(x, y - 1);
    }

    public static void move(int x, int y) {
        if (x < 0 || y < 0) return;
        if (x >= M || y >= N) return;
        if (table.get(x)[y] == null) return;
        if (table.get(x)[y] != 1) return;
        flag = true;
        DFS(x, y);
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            getStaticValues();
            initTable();
            controller();
        }

        br.close();
    }
}
