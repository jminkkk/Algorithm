import java.io.*;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[10001];
        StringBuilder sb = new StringBuilder();

        for (int i=1; i <=10000; i++){
            a[i] = 0;
        }

        for (int i=1; i <=10000; i++){
            int b = 0;
            int sum = i;
            String[] str = String.valueOf(i).split("");

            for(int j =0; j< str.length; j++){
                sum += Integer.parseInt(str[j]);
            }

            if(sum <= 10000) a[sum] = ++b;
        }

        for (int i=1; i <=10000; i++){
            if(a[i] == 0 ) sb.append(i + "\n");
        }

        System.out.println(sb);
    }
}