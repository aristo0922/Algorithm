import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int size;
    static int[][] table;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int LIMIT = Integer.MIN_VALUE;
    static int answer = Integer.MIN_VALUE;
    static int count = 0;

    static Deque<Node> queue = new LinkedList<>();

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        StringTokenizer st;
        table = new int[size][size];
        visited = new boolean[size][size];
// init
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                if (LIMIT < table[i][j])
                    LIMIT = table[i][j];
            }
        }

        //search
        for (int limit = 0; limit <= LIMIT; limit++) {
            manage(limit);
            if (answer < count) answer = count;
            count = 0;
            visited = new boolean[size][size];
        }

        System.out.println(answer);
    }

    public static void manage(int limit) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] <= limit || visited[i][j] == true) continue;
                DFS(i, j, limit);
                count++;
            }
        }
    }

    public static void DFS(int x, int y, int limit) {
        if (table[x][y] <= limit || visited[x][y] == true) return;
        visited[x][y] = true;

        // 다음 노드 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= size || ny >= size) continue;
            queue.add(new Node(nx, ny));
        }

//        재귀
        while (queue.size() > 0) {
            Node node = queue.pollFirst();
            DFS(node.x, node.y, limit);
        }
    }


}
