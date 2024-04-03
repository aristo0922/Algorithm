import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2003
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());// ㅂㅐ열의 길이
        int M = Integer.parseInt(st.nextToken());// 합이 M이 되는 경우의 수

        int A[] = new int[N+1];
        int result =0;

        st = new StringTokenizer(bf.readLine());

        for (int i =0 ;i<N ; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }

        int start_index=0;
        int end_index=0;
        int sum=A[0];
        while(end_index<N){
            if(sum==M){
                result++;
                sum+=A[++end_index];
            }else if (sum<M){
                sum+=A[++end_index];
            }else{
                sum-=A[start_index++];
            }
        }

        System.out.println(result);
        bf.close();


    }
}
