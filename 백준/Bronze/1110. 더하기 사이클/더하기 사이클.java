import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int Na, Nb;
        int sum = N;
        int cycle = 0;

        while (true){
            Na = sum / 10; //2
            Nb = sum % 10; //6
            sum = Na+Nb;

            sum = (Nb*10) + (sum % 10);
            cycle++;
            if(N == sum) break;
        }
        System.out.println(cycle);
    }
}
