package com.march;

//https://leetcode.com/problems/string-compression/
public class Mar02 {
    public static void main(String[] args) {

    }

    static int compress(char[] chars) {

        int len = 0;
        int i = 0;

        while(i < chars.length){
            int j = i;
            while( j < chars.length && chars[j] == chars[i]){
                j++;
            }

            chars[len++] = chars[i];
            // to see about repetition

            if( j - i > 1){
                String count = j - i + "";
                for(char c : count.toCharArray()){
                    chars[len++] = c;
                }
            }

            i = j;
        }

        return len;
    }
}
