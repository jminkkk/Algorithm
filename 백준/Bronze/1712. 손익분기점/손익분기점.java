import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int A = Integer.parseInt(st.nextToken());    // 고정 비용
        int B = Integer.parseInt(st.nextToken());    // 가변 비용
        int C = Integer.parseInt(st.nextToken());    // 정가 비용

        if(C <= B) System.out.println("-1");
        else System.out.println((A/(C-B)+1));


    }
}