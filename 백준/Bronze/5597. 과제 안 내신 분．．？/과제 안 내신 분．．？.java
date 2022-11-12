import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stNum = new int[31];
        int n,k = 0;

        for(int i = 0 ; i<28 ; i++){
            k = Integer.parseInt(br.readLine());
            stNum[k] = 1;
        }

        for (n=1 ; n<stNum.length ; n++){
            if(stNum[n] != 1) System.out.printf(n + " ");
        }
    }
}
