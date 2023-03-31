import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        // 수학은 비대면
        // ax + by = c
        // dx + ey = f

        // 입력 : a b c d e f
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strStr = br.readLine().split(" ");
        Double[] str = new Double[strStr.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = Double.parseDouble(strStr[i]);
        }

        int x = 0, y = 0;

        // 출력 : x y
        for (int i = -999; i < 1000; i++) {
            for(int j = -999; j < 1000; j++) {
                if(str[0] * i + str[1] *j == str[2] && str[3] * i + str[4] *j == str[5]){
                    x = (int) i;
                    y = (int )j;
                    break;
                }
            }
        }
        System.out.println(x + " " + y);
    }
}