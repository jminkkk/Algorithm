import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(str, " ");
            String part = st.nextToken();
            String entire = st.nextToken();
            int index = 0;

            for(int i = 0; i < entire.length(); i++) {
                if(part.charAt(index) == entire.charAt(i)){
                    index++;
                };
                if (index == part.length()) break;
            }

            if(index == part.length()) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}