import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
// 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
// (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
// (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
// 첫째 줄에 연결 요소의 개수를 출력한다.
public class Main {
    // idea: hash set 을 하나의 연결 요소로 본다. hash set이 몇개 있는지(List 사용해서 엮고, count로 갯수 세기.
    // why? 뒷족 입력에서 두 요소가 연결되었을 때 하나로 묶이는데 list 에서 null 로 변환해서 처리? -> 그래도 카운팅 되지 않을가?
    static Data[] nodes ;
    static int MAX ;
    static int COUNT ;

    public static class Data {
        private List<Integer> adj;
        private boolean isVisited;

        Data() {
            adj = new ArrayList<>();
            isVisited = false;
        }

        void addAdj(int node){
            this.adj.add(node);
        }

        List<Integer> getAdj(){
            return this.adj;
        }

        void visit() {
            this.isVisited = true;
        }

        boolean isVisited() {
            return this.isVisited;
        }
    }

    public static void control(){
        int result = 0 ;
        for(int i=0;i<MAX;i++){
            Data node = nodes[i];
            if(node.isVisited==false){
                result++;
            }
            if(node.isVisited==true) continue;
            node.visit();
            List<Integer> adj = node.getAdj();
            DFS(adj);
        }

        System.out.println(result);
    }

    static void DFS(List<Integer> adj){
        for(int n: adj){
            if(nodes[n-1].isVisited==true) continue;

            nodes[n-1].visit();
            DFS(nodes[n-1].getAdj());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        MAX = Integer.parseInt(st.nextToken());
        COUNT = Integer.parseInt(st.nextToken());

        nodes = new Data[MAX];
        for(int i =0 ;i<MAX;i++){
            nodes[i] = new Data();
        }

        for (int i = 0; i < COUNT; i++) {
            st = new StringTokenizer(br.readLine());
            int numA = Integer.parseInt(st.nextToken());
            int numB = Integer.parseInt(st.nextToken());

            nodes[numA-1].addAdj(numB);
            nodes[numB-1].addAdj(numA);
        }

        control();


    }
}
