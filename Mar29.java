package com.march;

import java.util.Arrays;
import java.util.Collections;

//https://leetcode.com/problems/reducing-dishes/
public class Mar29 {
    public static void main(String[] args) {

    }
    public int maxSatisfaction(int[] satisfaction) {
        int ans = 0;
        int sumSatisfaction = 0;

        satisfaction = Arrays.stream(satisfaction)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for (final int s : satisfaction) {
            sumSatisfaction += s;
            if (sumSatisfaction <= 0)
                return ans;
            ans += sumSatisfaction;
        }

        return ans;
    }
}
