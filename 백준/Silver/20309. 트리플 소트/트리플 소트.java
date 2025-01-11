import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);

        int[] arr = new int[n];
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        while (true) {
            for (int i = 0; i <= arr.length - 2; i++) {
                if (i + 2 < arr.length && arr[i] > arr[i + 2]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 2];
                    arr[i + 2] = tmp;
                }
            }

            boolean sort2 = sort2(arr);
            boolean allSort = allSort(arr);
            if (sort2) {
                if (allSort) {
                    System.out.println("YES");
                    return;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
    }

    private static boolean allSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean sort2(int[] arr) {
        for (int i = 0; i < arr.length - 2; i += 2) {
            if (arr[i] > arr[i + 2]) {
                return false;
            }
        }

        return true;
    }
}
