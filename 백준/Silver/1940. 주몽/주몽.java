import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// 백준 1940 주몽
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());// 재료의 갯수
        int M = Integer.parseInt(bf.readLine());// 갑옷의 고유 숫자

        int []A = new int[N];//재료의 수 만큼 배열 생성
        StringTokenizer st = new StringTokenizer((bf.readLine()));
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);//배열 정렬

        int count =0;
        int i=0;
        int j = N-1;
        while(i<j){
            if(A[i]+A[j]<M){
                i++;
            }else if (A[i]+A[j] > M){
                j--;
            }else{
                count ++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        bf.close();
    }
}
