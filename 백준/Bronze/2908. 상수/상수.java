import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        String[] num1 = st.nextToken().split("");
        String[] num2 = st.nextToken().split("");

        if(Integer.parseInt(num1[2]) > Integer.parseInt(num2[2])) System.out.println(num1[2]+""+num1[1]+""+num1[0]);
        //100의 자리수가 num1이 더 클때
        else if (Integer.parseInt(num1[2])== Integer.parseInt(num2[2])) {
            //100의 자리수가 같을 때
            if(Integer.parseInt(num1[1])> Integer.parseInt(num2[1])) System.out.println(num1[2]+""+num1[1]+""+num1[0]);
            //10의 자리수가 1이 더 클때
            else if (Integer.parseInt(num1[1]) == Integer.parseInt(num2[1])) {
                //10의 자리수가 같을때
                if (Integer.parseInt(num1[0]) > Integer.parseInt(num2[0])) System.out.println(num1[2]+""+num1[1]+""+num1[0]);
                else System.out.println(num2[2]+""+num2[1]+""+num2[0]);
            }
            else System.out.println(num2[2]+""+num2[1]+""+num2[0]);
            //10의 자리수가 2이 더 클때
        }

        else System.out.println(num2[2]+""+num2[1]+""+num2[0]);
        //100의 자리수가 num2이 더 클때

    }
}