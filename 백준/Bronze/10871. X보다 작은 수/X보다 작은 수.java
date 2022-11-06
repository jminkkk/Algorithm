import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str," ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] stNum = new int[N];

        str = br.readLine();
        st = new StringTokenizer(str," ");

        for(int i =0; i<N; i++){
            stNum[i] = Integer.parseInt(st.nextToken());
            if(stNum[i]<X) {
                bw.write(stNum[i]+" ");}
        }
        bw.flush();
        bw.close();

    }
}
