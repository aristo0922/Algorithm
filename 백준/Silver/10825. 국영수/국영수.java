import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static class Student {
        String name;
        int scoreKorean;
        int scoreEnglish;
        int scoreMath;

        public Student() {
        }

        public Student(String[] values) {
            this.name = values[0];
            this.scoreKorean = Integer.parseInt(values[1]);
            this.scoreEnglish = Integer.parseInt(values[2]);
            this.scoreMath = Integer.parseInt(values[3]);
        }

        public int getKorean() {
            return this.scoreKorean;
        }

        public int getEnglish() {
            return this.scoreEnglish;
        }

        public int getMath() {
            return this.scoreMath;
        }

        public String getName() {
            return this.name;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tryNum = Integer.parseInt(br.readLine());
        String result = IntStream.range(0, tryNum)
                .mapToObj(i -> {
                    try {
                        return new Student(br.readLine().split(" "));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return new Student();
                    }
                })
                .sorted(Comparator.comparing(Student::getKorean).reversed()
                        .thenComparing(Student::getEnglish).reversed()
                        .thenComparing(Student::getMath).reversed()
                        .thenComparing(Student::getName))
                .map(Student::getName)
                .collect(Collectors.joining("\n"));
        bw.write(result);
        bw.flush();
    }
}
