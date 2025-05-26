import java.util.*;
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

        List<Integer> list = new ArrayList<>();
        while (sum >= 1) {
            list.add(sum % 2);
            sum /= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        System.out.println(sb.toString());
    }
}