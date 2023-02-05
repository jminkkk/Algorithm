import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int R = Integer.parseInt(st.nextToken());
            String[] noP = st.nextToken().split("");

            for(int k=0; k< noP.length;k++) {
                for (int j = 0; j < R; j++) {
                    sb.append(noP[k]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}