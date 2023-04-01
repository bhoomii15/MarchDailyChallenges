package com.march;

import java.util.Arrays;

//https://leetcode.com/problems/sort-an-array/
public class Mar01 {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        System.out.println(Arrays.toString(sortArray(arr)));
    }
    static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    static int[] sortArray(int[] nums) {
        final int N = nums.length;
        int[] aux = new int[N];
        sort(nums, aux, 0, N - 1);
        return nums;
    }
}
