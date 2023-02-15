import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int count = 0 ;//소수의 개수

        for(int i = 0; i<N; i++){
            if(IsDecimal(Integer.parseInt(st.nextToken()))) count++;
        }

        System.out.println(count);
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
