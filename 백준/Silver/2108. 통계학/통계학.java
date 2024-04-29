import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNum = Integer.parseInt(br.readLine());
        int[] arr = new int[tryNum];
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = 0;
        int max = 0;
        ArrayList<Integer> key = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tryNum; i++) {
            int node = Integer.parseInt(br.readLine());
            arr[i] = node;
            total += node;
            if (!map.containsKey(node)) {
                map.put(node, 0);
            }
            int value = map.get(node);
            map.put(node, value + 1);
            if (value + 1 == max) {
                key.add(node);
            }
            if (value + 1 > max) {
                max = value + 1;
                key = new ArrayList<>();
                key.add(node);
            }
        }

        Arrays.sort(arr);

        sb.append((int)Math.round((double)total / tryNum) + "\n");
        sb.append(arr[(tryNum) / 2] + "\n");


        if (key.size() == 1) {
            sb.append(key.get(0) + "\n");
        } else {
            Integer [] result = new Integer[key.size()];
            result = key.toArray(result);
            Arrays.sort(result);
            sb.append(result[1] + "\n");
        }


        sb.append(arr[tryNum - 1] - arr[0]);

        System.out.println(sb);
    }
}