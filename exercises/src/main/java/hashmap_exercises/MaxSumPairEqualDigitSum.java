package hashmap_exercises;

import java.util.HashMap;
import java.util.Map;

public class MaxSumPairEqualDigitSum {

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> best = new HashMap<>();
        int answer = -1;

        for (int x : nums) {
            int d = digitSum(x);

            if (best.containsKey(d)) {
                // We already have a number with this digit sum
                answer = Math.max(answer, best.get(d) + x);

                // Update best if current number is larger
                best.put(d, Math.max(best.get(d), x));
            } else {
                // First time seeing this digit sum
                best.put(d, x);
            }
        }

        return answer;
    }

    int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}