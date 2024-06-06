import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[][][] box;

    static Queue<Integer> toClearX;
    static Queue<Integer> toClearY;
    static Queue<Integer> toClearH;
    static Queue<Integer> nextClearX = new ArrayDeque<>();
    static Queue<Integer> nextClearY = new ArrayDeque<>();
    static Queue<Integer> nextClearH = new ArrayDeque<>();
    static int unClear = 0;
    static int dates = -1; // 첫째날부터 카운팅 하기 위해

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        box = new int[M][N][H];
        toClearX = new ArrayDeque<>();
        toClearY = new ArrayDeque<>();
        toClearH = new ArrayDeque<>();
        for (int height = 0; height < H; height++) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int node = Integer.parseInt(st.nextToken());
                    box[i][j][height] = node;
                    if (node == 0) unClear++;
                    if (node == 1) {
                        toClearX.add(i);
                        toClearY.add(j);
                        toClearH.add(height);
                    }
                }
            }
        }

        if (unClear == 0) {
            System.out.println(0);
            return;
        }

        do {
            // 바꿀 때마다 unClear --;
            nextClearX = new ArrayDeque<>();
            nextClearY = new ArrayDeque<>();
            nextClearH = new ArrayDeque<>();

            while (toClearX.size() != 0) {
                int x = toClearX.poll();
                int y = toClearY.poll();
                int h = toClearH.poll();
//                if (box[x][y][h] == 2)
//                    continue;
                if(toClearX.size()==0)
                    dates++;
                BFS(x, y, h);
            }
            toClearX = nextClearX;
            toClearY = nextClearY;
            toClearH = nextClearH;
        } while (nextClearX.size() != 0);

        if (unClear > 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(dates-1);
    }

    public static boolean validIndex(int x, int y, int h) {
        if (x < 0 || y < 0 || h < 0 || h >= H || x >= M || y >= N) return false;//상자 밖
        return true;
    }

    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void addNext(int x, int y, int h) {
        if (box[x][y][h] == -1)
            return;
        if (box[x][y][h] == 2)
            return;
        for (int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nh = h + dh[i];
            if (validIndex(nx, ny, nh)) {
                nextClearX.add(nx);
                nextClearY.add(ny);
                nextClearH.add(nh);
            }
        }
    }

    public static void BFS(int x, int y, int h) {
        if (box[x][y][h] == -1)
            return;
        if (box[x][y][h] == 0)
            unClear--;
        addNext(x, y, h);
        box[x][y][h] = 2;
    }
}
