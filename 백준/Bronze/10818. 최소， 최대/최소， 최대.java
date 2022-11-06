import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        st = new StringTokenizer(str," ");
        int[] stNum = new int[N];
        int min, max;

        for(int i =0; i<N; i++){
            stNum[i] = Integer.parseInt(st.nextToken());
        }
        min = stNum[0];
        max = stNum[0];

        for(int i=0; i<N; i++){
            if(min>stNum[i]) min=stNum[i];
            else if (max<stNum[i]) max=stNum[i];
        }
        System.out.print(min+" "+max);
    }
}
