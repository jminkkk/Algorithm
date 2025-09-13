import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {        
        List<Integer> list = new ArrayList<>();
        // 약관 종류 및 유효기간
        Map<String, Integer> typesAndMonth = new HashMap<>();
        for (String term: terms) {
            String[] arr = term.split(" ");
            typesAndMonth.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        LocalDate todayDate = of(today);
        
        // 개인정보 번호 및 수집일자
        Map<Integer, LocalDate> numsAndDue = new HashMap<>();
        for (int i = 0; i < privacies.length; i++) { // 날짜 약관종류
            String privacie = privacies[i];
            String[] arr = privacie.split(" ");
            LocalDate start = of(arr[0]);
            int month = typesAndMonth.get(arr[1]);
            LocalDate end = start.plusMonths(month);
            
            if (end.isBefore(todayDate) || end.isEqual(todayDate)) list.add(i + 1);
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
    
    public LocalDate of(String date) {
        String[] arr = date.split("\\.");
        // return LocalDate.now();
        return LocalDate.of(Integer.parseInt(arr[0]), 
                            Integer.parseInt(arr[1]), 
                            Integer.parseInt(arr[2]));
    }
}