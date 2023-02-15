import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer M = Integer.parseInt(br.readLine());
        Integer N = Integer.parseInt(br.readLine());

        int[] Decimal = new int[N-M+1];//소수들
        int j = 0;

        for(int i = M; i<=N; i++){
            if(IsDecimal(i)) {
                Decimal[j++] = i;
            }
        }

        if(Decimal[0] == 0) System.out.println("-1");
        else {
            System.out.println(Arrays.stream(Decimal).sum()); //소수들의 합 출력
            System.out.println(Decimal[0]); //최솟값 출력
        }
    }

    private static Boolean IsDecimal(int num) {
        int quotientCount = 0;
        if(num == 1) return false;
        else {
            for(int i =2; i<= num/2; i++){
                if(num%i == 0) quotientCount++;
        }
        if(quotientCount != 0) return false;
        else return true;
        }
    }
}
