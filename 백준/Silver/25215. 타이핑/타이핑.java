import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        boolean isActive = false; 
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if ( !(isActive && str.charAt(i) >= 'a') &&
                    !(!isActive && str.charAt(i) < 'a')) {
                count++;
                continue;
            }

            count += 2;
            if ((isActive && str.charAt(i + 1) >= 'a') ||
                    (!isActive && str.charAt(i + 1) < 'a')) {
                isActive = !isActive;
            }
        }

        if ((!isActive && str.charAt(str.length() - 1) >= 'a') ||
                (isActive && str.charAt(str.length() - 1) < 'a')) {
            count++;
        } else {
            count += 2;
        }

        System.out.println(count);
    }
}
