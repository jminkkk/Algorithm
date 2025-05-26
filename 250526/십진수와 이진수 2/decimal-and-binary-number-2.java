import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.
        int binaryInt = Integer.parseInt(binary);
        int sum = 0;
        int cnt = 0;

        while (binaryInt > 0) {
            sum += Math.pow(2, cnt++) * (binaryInt % 10);
            binaryInt /= 10;
        }
        
        sum *= 17;
        cnt = 0;

        int answer = 0;
        while (sum >= 2) {
            answer += (sum % 2) * Math.pow(10, cnt++);
            sum /= 2;
        }

        answer += (sum % 2) * Math.pow(10, cnt++);
        System.out.println(answer);
    }
}