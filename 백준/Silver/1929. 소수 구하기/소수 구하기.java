import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i=M; i<=N; i++){
            if(isPrime(i)) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int i) {
        int count = 0;
        if(i == 1) return false;
        else {
            for(int j = 2; j*j <= i; j++) if(i%j == 0) count ++;

            if(count == 0) return true;
            else return false;
        }
    }
}
