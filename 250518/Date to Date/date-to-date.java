import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        
        int sum = 0;
        while (true) {
            if (m1 == m2) {
                if (d1 >= d2) {
                    sum += (d2 - d1) + 1;
                } else {
                    sum += (d2 - d1);
                }
                break;
            }

            if (m1 == 1 || m1 == 3 || m1 == 5 || m1 == 7 || m1 == 9 || m1 == 11) {
                sum += 31;
                m1++;
            } else if (m1 == 2){
                sum += 28;
                m1++;
            } else {
                sum += 30;
                m1++;
            }
        }

        System.out.println(sum);
    }
}