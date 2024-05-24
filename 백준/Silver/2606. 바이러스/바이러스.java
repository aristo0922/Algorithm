import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//첫째 줄에는 컴퓨터의 수가 주어진다.
// 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
// 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
// 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
public class Main {
    static List<ArrayList<Integer>> computers;
    static HashSet<Integer> isConta = new HashSet<>();

    public static void addNetwork(int com1, int com2){
        computers.get(com1).add(com2);
        computers.get(com2).add(com1);
    }

    public static void DFS(int n){
        if(isConta.contains(n)) return;
        isConta.add(n);
        ArrayList<Integer> network = computers.get(n);
        for(Integer com: network){
            DFS(com);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tryNum = Integer.parseInt(br.readLine());
        computers = new ArrayList<>(tryNum+1);
        int networksNum = Integer.parseInt(br.readLine());

        for(int i=0;i<=tryNum;i++){
            computers.add(new ArrayList<>());
        }

        for(int i=0;i<networksNum;i++){
            String[] nums = br.readLine().split(" ");
            int comIndex1 = Integer.parseInt(nums[0]);
            int comIndex2 = Integer.parseInt(nums[1]);
            addNetwork(comIndex1, comIndex2);
        }
        DFS(1);

        System.out.println(isConta.size()-1);
    }
}
