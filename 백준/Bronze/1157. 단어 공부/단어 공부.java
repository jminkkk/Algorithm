import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine().toUpperCase();
        int[] frequency = new int[26];
        int big = 0;
        int[] result = new int[26];
        int k =0;

        //빈도수 계산
        for(int i =0; i<N.length(); i++ ) frequency[(int) N.charAt(i)-65]++;

        //최대 빈도수 확인
        for(int i =0; i<frequency.length; i++) if(frequency[i] > big) big = frequency[i];

        for(int i=0; i<frequency.length; i++){
            if(frequency[i] == big) result[k++] = i;
        }

        if(result[1] != 0) System.out.println("?");
        else System.out.println((char) (result[0]+'A'));
    }
}