import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Point {
        int height;
        int row;
        int col;

        public Point(int h, int r, int c) {
            this.height = h;
            this.row = r;
            this.col = c;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int rowArr[] = {0, 0, 0, 0, 1, -1};
    static int colArr[] = {0, 0, 1, -1, 0, 0};
    static int heightArr[] = {1, -1, 0, 0, 0, 0};
    static int m, n, h;
    static int arr[][][];
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h + 1][n + 1][m + 1];

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) queue.add(new Point(i, j, k));
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int height = point.height;
            int col = point.col;
            int row = point.row;

            for (int i = 0; i < 6; i++) {
                int nh = height + heightArr[i];
                int ncol = col + colArr[i];
                int nrow = row + rowArr[i];

                if (checkPoint(nh, nrow, ncol)) {
                    queue.add(new Point(nh, nrow, ncol));
                    arr[nh][nrow][ncol] = arr[height][row][col] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (arr[i][j][k] == 0) return -1;
                    result = Math.max(result, arr[i][j][k]);
                }
            }
        }
        if (result == 1) return 0;
        else return (result - 1);
    }

    private static boolean checkPoint(int height, int row, int col) {
        if (height < 1 || height > h || row < 1 || row > n || col < 1 || col > m) return false;
        if (arr[height][row][col] == 0) return true;
        return false;
    }
}
