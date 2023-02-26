import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        String S = br.readLine();
        String K = br.readLine();

        S = S.replaceAll("[0-9]", "");

        if(S.contains(K)) System.out.println("1");
        else System.out.println("0");
    }
}