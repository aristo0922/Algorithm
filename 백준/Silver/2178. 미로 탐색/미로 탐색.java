import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> todoes = new ArrayList<>();
    static List<String> nextDo = new ArrayList<>();
    static List<String> isVisited = new ArrayList<>();
    static char[][] arr;
    static int result = 0;
    static int N, M;


    public static void nextGeneration() {
        todoes = nextDo;
        nextDo = new ArrayList<>();
    }

    public static void BFS(int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(i).append(" ").append(j);

        isVisited.add(sb.toString());
        addTodoes(i, j - 1);
        addTodoes(i, j + 1);
        addTodoes(i - 1, j);
        addTodoes(i + 1, j);
    }

    public static void addTodoes(int i, int j) {
        if (i < 0 || j < 0) return;
        if (i >= N || j >= M) return;
        StringBuilder sb = new StringBuilder();
        sb.append(i).append(" ").append(j);
        if (isVisited.contains(sb.toString())) return;
        if (todoes.contains(sb.toString())) return;
        if (nextDo.contains(sb.toString())) return;


        if (arr[i][j] == '1') {
            nextDo.add(sb.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);

        arr = new char[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        todoes.add("0 0");

        do {
            for (String todo : todoes) {
                int x = Integer.parseInt(todo.split(" ")[0]);
                int y = Integer.parseInt(todo.split(" ")[1]);
                if (x == N-1 && y == M-1) {
                    nextGeneration();
                    result += 1;

                    System.out.println(result);
                    break;
                }
                BFS(x, y);
            }
            nextGeneration();
            result += 1;
        } while (todoes.size() > 0);
    }
}
