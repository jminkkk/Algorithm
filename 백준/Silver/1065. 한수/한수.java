import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int ans = 0;// 한수

        if(a<100) System.out.println(a);

        else {
            ans = 99;
            for(int i = 100; i<= a; i++){
                int a100 = i/100;
                int a10 = (i/10)%10;
                int a1= i%10;

                if((a100 - a10) == (a10 - a1))
                  ans++;
            }
            System.out.println(ans);
        }
    }
}