package com.march;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-time-to-complete-trips/
public class Mar07 {
    public static void main(String[] args) {

    }

    public long minimumTime(int[] time, int totalTrips) {
        long l = 1;
        long r = Arrays.stream(time).min().getAsInt() * (long) totalTrips;

        while (l < r) {
            final long m = (l + r) / 2;
            if (numTrips(time, m) >= totalTrips)
                r = m;
            else
                l = m + 1;
        }

        return l;
    }

    private long numTrips(int[] time, long m) {
        return Arrays.stream(time).asLongStream().reduce(0L, (subtotal, t) -> subtotal + m / t);
    }
}
