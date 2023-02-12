import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[][] arr = new int[1000][];
        int i = 0;
        int mo = 0, son = 0;

        for(; i< 10000000; i++)
            if( i*(i+1)/2 < N && (i+1)*(i+2)/2 >= N ) {//N이 몇 번째 줄(i)에 있는지 검사
                break;
            }


        for(int j = (i*(i+1)/2) + 1 ; j <= N ;j++){
            if(i % 2 == 1){ // 홀수면 <-
                son ++;
                mo = i - son + 2;
            }
            else { //짝수면 ->
                mo++;
                son = i - mo + 2;
            }
        }

        System.out.println(son + "/" + mo);
    }
}