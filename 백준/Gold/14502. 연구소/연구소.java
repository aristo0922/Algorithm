//인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
//연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
//일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
//예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

import java.io.*;
import java.util.*;

//이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int answer = 0;
    public static int[][] table;
    static List<Node> queue = new ArrayList<>();
    static int initSize;
    static int[][] compare;
    static Queue<Node> willVistit = new ArrayDeque<>();

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        table = new int[N][M];
        compare = new int[N][M];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                if (table[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }
        initSize = queue.size();
        // 벽을 세우는 모든 경우의 수 적용
        DFS(0);
        System.out.println(answer);
    }

    public static void DFS(int wallCount) {
        if (wallCount == 3) {
            for(int i=0;i<N;i++){
                compare[i] = table[i].clone();
            }
            BFS();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (table[i][j] == 0) {
                    table[i][j] = 1;
                    DFS(wallCount + 1);
                    table[i][j] = 0;
                }
            }
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void BFS() {
        for (int index = 0; index < queue.size(); index++) {
            willVistit.add(queue.get(index));
        }
        while (willVistit.size() > 0) {
            Node node = willVistit.poll();
            for (int i = 0; i < 4; i++) {
                setVirus(new Node(node.x+dx[i], node.y+dy[i]));
            }
        }
        getAnswer();

    }

    public static void setVirus(Node node) {
        int x = node.x;
        int y = node.y;
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return;
        }
        if (compare[x][y] == 0) {
            compare[x][y] = 2;
            willVistit.add(new Node(x, y));
        }
    }

    public static void getAnswer() {
        int result =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(compare[i][j] == 0){
                    result++;
                }
            }
        }
        if(result > answer){
            answer = result;
        }
    }
}
