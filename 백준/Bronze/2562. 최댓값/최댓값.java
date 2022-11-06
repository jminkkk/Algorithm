import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stNum = new int[9];
        int max=0, Mindex=0;

        for(int i =0; i<9; i++){
            stNum[i] = Integer.parseInt(br.readLine());
            if(max<stNum[i]) {
                Mindex=i+1;
                max = stNum[i];
            }
        }
        System.out.println(max);
        System.out.println(Mindex);
    }
}
