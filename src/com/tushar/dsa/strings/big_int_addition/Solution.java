package com.tushar.dsa.strings.big_int_addition;

// Question: https://leetcode.com/problems/multiply-strings/
// Good explanation: https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
public class Solution {
    public String addStrings(String num1, String num2) {

        String longerNum;
        String shorterNum;

        if (num1.length() > num2.length()){
            longerNum = num1;
            shorterNum = num2;
        } else {
            longerNum = num2;
            shorterNum = num1;
        }

        int[] result = new int[longerNum.length() + 1];

        int longerIndex = longerNum.length() - 1;
        int shorterIndex = shorterNum.length() - 1;
        int resultIndex = result.length - 1;

        int carry = 0;

        // System.out.println("longerIndex: "  + longerIndex + ", shorterIndex: " + shorterIndex);

        while(shorterIndex >= 0){
            int sum = longerNum.charAt(longerIndex) - '0' + shorterNum.charAt(shorterIndex) - '0' + carry;
            result[resultIndex] = sum % 10;
            carry = sum / 10;

            longerIndex--;
            shorterIndex--;
            resultIndex--;
        }

        // System.out.println("longerIndex: "  + longerIndex + ", shorterIndex: " + shorterIndex);

        while(longerIndex >= 0) {
            int sum = longerNum.charAt(longerIndex) - '0' + carry;
            result[resultIndex] = sum % 10;
            carry = sum / 10;
            longerIndex--;
            resultIndex--;
        }

        result[0] += carry;

        /*
        for (int num : result) {
            System.out.print(num + ",");
        }
        */

        StringBuilder finalResult = new StringBuilder();
        for (int num : result) {
            if (num == 0 && finalResult.length() == 0)
                continue;
            finalResult.append(num);
        }

        return finalResult.length() == 0 ? "0" : finalResult.toString();
    }
}
