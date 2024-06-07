import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] table;
    static int[][] tableCopy;
    static Queue<Locate> nextVisite = new LinkedList<>();
    static int size = 0;
    static int answer = Integer.MIN_VALUE;
    static int count = 0;
    static int MAX = Integer.MIN_VALUE;

    public static class Locate {
        int x, y;

        public Locate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        table = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                if (MAX < table[i][j])
                    MAX = table[i][j];
            }
        }

        for (int limit = 0; limit <= MAX; limit++) {
            DeepCopy();
            count = 0;
            manage(limit);
            if (count > answer) answer = count;
        }

        System.out.println(answer);
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void DeepCopy() {
        tableCopy = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tableCopy[i][j] = table[i][j];
            }
        }
    }

    static void manage(int limit) {
        count=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tableCopy[i][j] <= limit || tableCopy[i][j] == -1) continue;
                DFS(i, j, limit);
                count++;
            }
        }
    }

    public static void DFS(int x, int y, int limit) {
        if (tableCopy[x][y] <= limit || tableCopy[x][y] == -1) return;
        tableCopy[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || size <= nx || size <= ny) continue;
            nextVisite.add(new Locate(nx, ny));
        }
        while (nextVisite.size() > 0) {
            Locate node = nextVisite.poll();
            DFS(node.x, node.y, limit);
        }
    }
}
