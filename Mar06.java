package com.march;

//https://leetcode.com/problems/kth-missing-positive-number/
public class Mar06 {
    public static void main(String[] args) {

    }
    public int findKthPositive(int[] arr, int k) {
        if(arr[0] > k){
            return k;
        }

        int start = 0;
        int end = arr.length - 1;
        int rMid = 0;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] - (mid + 1) < k){
                rMid = mid + 1;
                start = mid +1;
            } else{
                end = mid - 1;
            }
        }
        return k + rMid;
    }
}
