package com.tushar.dsa.strings.big_int_multiplication;

// Question: https://leetcode.com/problems/multiply-strings/
// Good explanation: https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
public class Solution {
    public String multiply(String num1, String num2) {

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num2.length() - 1; i >= 0; i--){
            for (int j = num1.length() - 1; j >= 0 ; j--){

                int carryIndex  = i + j;
                int prodIndex = i + j + 1;

                // current prodIndex is last time's carryIndex, so add it to sum
                int prod = (num1.charAt(j) - '0')*(num2.charAt(i) - '0') + result[prodIndex];
                result[carryIndex] += prod / 10;
                result[prodIndex] = prod % 10;
            }
        }

        /*
        System.out.println("results:");
        for (int i = 0; i < resultsMaxSize ; i++){
            System.out.print(result[i] + ",");
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
