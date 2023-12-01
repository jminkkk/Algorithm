import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int serialNumCount = Integer.parseInt(br.readLine());
        List<SerialNum> serialNums = new ArrayList<>();

        for (int i = 0; i < serialNumCount; i++) {
            String word = br.readLine();
            serialNums.add(new SerialNum(word));
        }

        serialNums.sort(Comparator.naturalOrder());

        for (SerialNum serialNum : serialNums) {
            System.out.println(serialNum.word);
        }
    }
}

class SerialNum implements Comparable<SerialNum> {
    public String word;
    private int sum;


    public SerialNum(String word) {
        this.word = word;
        sum = getSum();
    }

    public int getSum() {
        int sum = 0;

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isAlphabetic(word.charAt(i))) {
                sum += word.charAt(i) - '0';
            }
        }

        return sum;
    }

    @Override
    public int compareTo(SerialNum o) {
        if (word.length() == o.word.length()) {
            if (sum == o.sum) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) > o.word.charAt(i)) {
                        return 1;
                    } else if (word.charAt(i) < o.word.charAt(i)) {
                        return -1;
                    }
                }
            } else return sum - o.sum;
        }
        return word.length() - o.word.length();
    }
}