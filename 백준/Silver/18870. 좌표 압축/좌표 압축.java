import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tryNum = Integer.parseInt(br.readLine());
        List<Integer> points = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Map<Integer, Integer> set = new HashMap<>();

        points.stream()
                .sorted()
                .distinct()
                .forEach(point -> set.put(point, set.size()));

        for(int i=0;i<tryNum;i++){
            bw.write(set.get(points.get(i))+ " ");
        }
        bw.flush();

    }
}
