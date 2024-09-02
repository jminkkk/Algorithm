import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> maps = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] typeAndDate = terms[i].split(" ");
            maps.put(typeAndDate[0], Integer.parseInt(typeAndDate[1]));
        }
        
        today = today.replace('.', '-');
        LocalDate now = LocalDate.parse(today);
        
        // 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] dateAndType = privacies[i].split(" ");
            
            dateAndType[0] = dateAndType[0].replace('.', '-');
            LocalDate magam = LocalDate.parse(dateAndType[0]);
            if (!magam.plusMonths(maps.get(dateAndType[1])).isAfter(now)) {
                index.add(i + 1);
            }
        }
        
        return index.stream().mapToInt(i -> i).toArray();
    }
}