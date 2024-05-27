import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> points = new ArrayList<>();
        int tryNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < tryNum; i++) {
            List<Integer> point = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            points.add(point);
        }

        List<List<Integer>> result = points.stream()
                .sorted(Comparator.comparingInt((List<Integer> point) -> point.get(0))
                        .thenComparingInt(point -> point.get(1)))
                .collect(Collectors.toList());

        for(List<Integer> point: result){
            bw.write(point.get(0) + " " + point.get(1)+"\n");
        }
        bw.flush();

    }
}
