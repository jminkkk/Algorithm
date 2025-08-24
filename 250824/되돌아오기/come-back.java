import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int ew = 0;
        int ns = 0;
        int cnt = 0;
        boolean comeback = false;

        for(int i = 0; i < n; i++){
            if (comeback) break;

            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();

            for (int j = 0; j < dist; j++) {
                if (dir == 'E') ew++;
                else if (dir == 'W') ew--;
                else if (dir == 'N') ns++;
                else if (dir == 'S') ns--;

                cnt++;
                
                if (ew == 0 && ns == 0) {
                    comeback = true;
                    System.out.println(cnt);
                    break;
                }
            }
        }

        if (!comeback) System.out.println(-1);
    }        
}