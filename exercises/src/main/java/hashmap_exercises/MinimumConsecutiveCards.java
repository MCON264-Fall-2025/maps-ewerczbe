package hashmap_exercises;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCards {

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int value = cards[i];

            if (lastSeen.containsKey(value)) {
                int j = lastSeen.get(value);
                answer = Math.min(answer, i - j + 1);
            }

            lastSeen.put(value, i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}