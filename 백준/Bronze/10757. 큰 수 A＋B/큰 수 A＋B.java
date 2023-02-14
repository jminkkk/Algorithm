import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        BigInteger a1 = new BigInteger(st.nextToken());
        BigInteger a2 = new BigInteger(st.nextToken());

        System.out.println(a1.add(a2));
    }
}