
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int money = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String[] input2 = input[0].split(":");
            int dd = Integer.parseInt(input[1]);
            int hh = Integer.parseInt(input2[0]);
            int mm = Integer.parseInt(input2[1]);

            if (hh >= 7 && hh < 18) {
                money += dd * 10;
            } else if (hh == 18) {
                if (mm + dd > 60) { // 45 20
                    money += (60 - mm) * 10;
                    money += (dd - (60 - mm)) * 5;
                } else {
                    money += dd * 10;
                }
            } else if (hh == 6) {
                if (mm + dd > 60) { // 45 20
                    money += (60 - mm) * 5;
                    money += (dd - (60 - mm)) * 10;
                } else {
                    money += dd * 5;
                }
            } else {
                money += dd * 5;
            }
        }

        System.out.println(money);
    }
}
