import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고,
// 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
// 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
public class Main {
    static List<char[]> appartments = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static boolean flag;
    static int num;


    public static void DFS(int i, int j) {
        checkGroup(i, j);
        move(i - 1, j);
        move(i, j - 1);
        move(i + 1, j);
        move(i, j + 1);
    }

    public static void move(int i, int j) {
        if (i < 0 || j < 0) return;
        if (i >= appartments.size() || j >= appartments.size()) return;
        if (appartments.get(i)[j] != '1') return;
        DFS(i, j);
        flag = true;
        countUp();
    }

    public static void countUp() {
        num++;
    }

    public static void checkGroup(int i, int j) {
        appartments.get(i)[j] = 'x';
    }

    public static void resetCheck() {
        if (flag == false) return;
        result.add(num);
        flag = false;
        num = 0;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        flag = false;

        for (int i = 0; i < N; i++) {
            appartments.add(br.readLine().toCharArray());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                resetCheck();
                move(i, j);
                resetCheck();
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int count : result) {
            System.out.println(count);
        }
    }
}
