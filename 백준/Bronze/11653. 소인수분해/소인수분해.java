import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Factorization = new int[N+1];
        int change = N;

        if (N == 0) ; //0이면 아무것도 X
        else {
            for (int i = 0; i <= N; i++) Factorization[i] = 0;

            for (int j = 2; j <= N; j++) {
                while (isQuotient(j,change)) {
                    change /= j;
                    Factorization[j]++; //j가 N의 몫이면 j번째 인덱스에 ++
                }
            }

            for (int k = 2; k<= N; k++)
                if(Factorization[k] != 0) { //0이면 N의 몫이 X
                    for(int h =0; h<Factorization[k]; h++)
                        System.out.println(k);
                }
        }

    }

    private static Boolean isQuotient(int j,int N) {
        if(N%j == 0) {
            return true;
        }
        return false;
    }
}
