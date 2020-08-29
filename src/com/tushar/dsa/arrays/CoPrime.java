package com.tushar.dsa.arrays;

public class CoPrime {

    static int gcd(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }

        if (num1 == num2) {
            return num1;
        }

        if (num1 > num2) {
            return gcd(num1 - num2, num2);
        }

        return gcd(num1, num2 - num1);
    }

    static boolean areCoPrime(int num1, int num2) {

        return (gcd(num1, num2) == 1);
    }

    public static boolean isCoPrimeToAll(int i, int[] nums) {
        for (int num : nums) {
            // if this number divides anyone
            if (num % i == 0 || !areCoPrime(i, num)) {
                return false;
            }
        }
        return true;
    }

    public static int findLowestCoPrime(int[] nums) {
        int maxNum = 0;
        for (int num :
                nums) {
            maxNum = Math.max(num, maxNum);
        }
        for (int i = 2; i <= maxNum; i++) {
            boolean found = true;
            if (isCoPrimeToAll(i, nums)) {
                return i;
            }
        }
        boolean found = false;
        int i = maxNum + 1;
        // keep trying till we don't get the answer
        while (true) {
            if (isCoPrimeToAll(i, nums)) {
                return i;
            }
            i++;
        }
    }
}
