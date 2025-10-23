package com.example.services;

public class StringUtils {

    public static Boolean isPalindrome(String value)
    {
        if (value == null) {
            return false;
        }
        
        String clean = value.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
