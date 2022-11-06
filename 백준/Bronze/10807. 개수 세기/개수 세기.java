import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count =0 ;
        int N = Integer.parseInt(br.readLine());
        int[] stNum = new int[N];
        String str = br.readLine();
        st = new StringTokenizer(str," ");
        int v = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
            stNum[i] = Integer.parseInt(st.nextToken());
            if(stNum[i]==v) count++;
        }
        System.out.println(count);
    }
}
