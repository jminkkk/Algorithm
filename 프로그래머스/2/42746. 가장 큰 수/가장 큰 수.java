import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, (String a, String b) -> {
            return (b + a).compareTo(a + b);
        });
    
        if (str[0].equals("0")) {
            return "0";
        }
        return String.join("", str);
    }
}

