package com.march;

//https://leetcode.com/problems/number-of-zero-filled-subarrays/
public class Mar21 {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0L;
        long count = 0L;

        for(int i : nums){
            if( i == 0){
                count++;
            } else{
                if(count > 0){
                    total += count * (count + 1L) >> 1;
                    count = 0;
                }
            }
        }

        if(count > 0){
            total += count * (count + 1L) >> 1;
        }
        return total;
    }
}
