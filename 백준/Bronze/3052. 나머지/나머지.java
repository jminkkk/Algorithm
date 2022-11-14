import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stNum = new int[10];
        int[] divNum = new int[42];
        int k;
        int count = 0;

        for (k=0 ; k<42 ; k++){
            divNum[k] = 0;
        }

        for(int i = 0 ; i<10 ; i++){
            stNum[i] = (Integer.parseInt(br.readLine())%42);
            for(k=0 ; k<42;k++){
                if(stNum[i] == k) {
                    divNum[k]++;
                }
            }
        }

        for (int n=0 ; n<42 ; n++){
            if(divNum[n] != 0) count++;
        }
        System.out.println(count);
    }
}
