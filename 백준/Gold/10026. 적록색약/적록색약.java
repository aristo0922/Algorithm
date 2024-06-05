import java.io.*;

public class Main {
    static int N;
    static String S;
    static char[][] arr;
    static boolean[][] visits;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N + 1][N + 1];
        visits = new boolean[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            S = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = S.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visits[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        int nomalCount = count;
        count = 0;
        visits = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visits[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(nomalCount + " " + count);
    }

    public static void dfs(int x, int y) {
        visits[x][y] = true;
        char temp = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > N || ny > N) {
                continue;
            }
            if(!visits[nx][ny] && arr[nx][ny] == temp)
                dfs(nx, ny);
        }
    }
}
