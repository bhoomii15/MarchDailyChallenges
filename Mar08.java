package com.march;

import java.util.Arrays;

//https://leetcode.com/problems/koko-eating-bananas/
public class Mar08 {

    public int minEatingSpeed(int[] piles, int h) {
        long start = 1;
        long end = Arrays.stream(piles).max().getAsInt();

        while(start <= end){
            int mid = (int)(start + (end -start)/2);

            if(canEat(piles, mid, h)){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }

        return (int)start;
    }

    public boolean canEat(int[] piles, int k, int h){
        long hrs = 0;
        for(long pile : piles){
            int div = (int)pile/k;
            hrs += div;
            if( pile % k != 0){
                ++hrs;
            }
        }

        return hrs <= h;
    }
}
