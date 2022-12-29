import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[] array = new int[26]; //위치를 나타낼 알파벳
        for(int i = 0; i<26; i++) array[i] = -1;

        for(int j =0; j<S.length(); j++) {
            char ch = S.charAt(j);
            if(array[ch - 'a']== -1) array[ch-'a'] = j;
        }

        for (int k = 0; k<26; k++) System.out.println(array[k]);
    }
}
