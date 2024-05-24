import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.sort;

public class Main {
    static int SIZE = 1_000 +1;
    static HashSet<Integer> isVisited = new HashSet<>();
    static Node[] nodes = new Node[SIZE];
    static Queue<Integer> nextDoor;

    public static class Node {
        private int number;
        private ArrayList<Integer> adj;

        public Node(int index) {
            this.number = index;
            adj = new ArrayList<>();
        }

        public void addAdj(int index) {
            adj.add(index);
        }

        public ArrayList<Integer> getAdjs() {
            return this.adj;
        }
    }

    public static StringBuilder BFS(int start, StringBuilder sb) {
        sb.append(start).append(" ");
        isVisited.add(start);
        ArrayList<Integer> adj = nodes[start].getAdjs();
        sort(adj);
        for (int node : adj) {
            if (isVisited.contains(node)) continue;
            if (nextDoor.contains(node)) continue;
            nextDoor.add(node);
        }
        return sb;
    }

    public static StringBuilder DFS(int start, StringBuilder sb) {
        sb.append(start).append(" ");
        isVisited.add(start);
        ArrayList<Integer> adj = nodes[start].getAdjs();
        sort(adj);
        for (int node : adj) {
            if (isVisited.contains(node)) continue;
            if (nextDoor.contains(node)) continue;
            DFS(node, sb);
        }
        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, V;

        for (int i = 0; i < SIZE; i++) {
            nodes[i] = new Node(i);
        }
        nextDoor = new ArrayDeque<>();

        String[] Commands = br.readLine().split(" ");
        N = Integer.parseInt(Commands[0]);
        M = Integer.parseInt(Commands[1]);
        V = Integer.parseInt(Commands[2]);
        nextDoor.add(V);

        for (int i = 0; i < M; i++) {
            String[] nums = br.readLine().split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);

            nodes[num1].addAdj(num2);
            nodes[num2].addAdj(num1);
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(DFS(V, sb));
        sb = new StringBuilder();
        nextDoor = new ArrayDeque<>();
        nextDoor.add(V);
        isVisited = new HashSet<>();

        do {
            sb = BFS(nextDoor.poll(), sb);
        } while (nextDoor.size() > 0);
        System.out.println(sb);
    }
}
