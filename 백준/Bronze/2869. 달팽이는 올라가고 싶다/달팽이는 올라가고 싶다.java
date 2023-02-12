import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int A = Integer.parseInt(st.nextToken()); //낮에 올라가는 높이
        int B = Integer.parseInt(st.nextToken()); //밤에 다시 내려오는 높이
        double V = Integer.parseInt(st.nextToken()); //나무 막대의 길이

        double day = (V-B)/(A-B);

        System.out.println((int)Math.ceil(day));
    }
}