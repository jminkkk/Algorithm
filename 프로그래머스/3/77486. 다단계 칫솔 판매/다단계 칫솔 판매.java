import java.util.*;

class Solution {

    public int[] solution(String[] enroll, String[] referral,
                           String[] seller, int[] amount) {

        int n = enroll.length;

        // 이름 -> 인덱스
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(enroll[i], i);
        }

        // 각 사람의 부모 인덱스
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = referral[i].equals("-")
                    ? -1
                    : index.get(referral[i]);
        }

        int[] profit = new int[n];

        // 판매 건별 정산
        for (int i = 0; i < seller.length; i++) {

            int current = index.get(seller[i]);
            int money = amount[i] * 100;

            while (current != -1 && money > 0) {

                int commission = money / 10;

                // 현재 판매자에게 90%
                profit[current] += money - commission;

                // 부모에게 10%
                money = commission;
                current = parent[current];
            }
        }

        return profit;
    }
}