import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        BigDecimal a = new BigDecimal(str[0]);
        BigDecimal b = new BigDecimal(str[1]);

        System.out.println(a.add(b));
    }
}
