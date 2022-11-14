import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double M = 0;
        int N = Integer.parseInt(br.readLine());
        double[] array = new double[N];
        double sum =0;

        String str = br.readLine();
        st = new StringTokenizer(str," ");

        for (int i=0 ; i<array.length ; i++){
            array[i] = Double.parseDouble(st.nextToken());
            if(array[i]>M) M = array[i];
        }

        for(int k = 0; k< array.length; k++){
            array[k] = array[k]/M*100;
            sum += array[k];
        }

        System.out.println(sum/N);
    }
}
