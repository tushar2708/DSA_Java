package com.tushar.questions.shrink_abc_string;


public class Solution {

    int[][][] mem = new int[101][101][101];

    private int merge(int a, int b, int c) {

//        System.out.println("a:" + a + ", b: " + b + ", c: " + c);

//        System.out.println(mem[a][b][c]);

        if (mem[a][b][c] != -1) {
//            System.out.println("returning: " + mem[a][b][c]);
            return mem[a][b][c];
        }

        // if only one character is present, we can't do any merging, and best solution would be equal to no of 3rd

        if (a == 0 && b == 0) {
//            System.out.println("a=0, b=0");
            mem[a][b][c] = c;
            return mem[a][b][c];
        }

        if (b == 0 && c == 0) {
//            System.out.println("b=0, c=0");
            mem[a][b][c] = a;
            return mem[a][b][c];
        }

        if (c == 0 && a == 0) {
//            System.out.println("c=0, a=0");
            mem[a][b][c] = b;
            return mem[a][b][c];
        }

        // if any one character is missing, remaining 2 merge and create that character
        if (a == 0) {
//            System.out.println("a=0");
            mem[a][b][c] = merge(a + 1, b - 1, c - 1);
            return mem[a][b][c];
        }

        //if b is not present, remaining 2 merge
        if (b == 0) {
//            System.out.println("b=0");
            mem[a][b][c] = merge(a - 1, b + 1, c - 1);
            return mem[a][b][c];
        }

        //if c is not present, remaining 2 merge
        if (c == 0) {
//            System.out.println("c=0");
            mem[a][b][c] = merge(a - 1, b - 1, c + 1);
            return mem[a][b][c];
        }

//        System.out.println("nothing=0");
        // else merge any 2, to create the third one, and pick the one with min size
        mem[a][b][c] = Math.min(merge(a + 1, b - 1, c - 1),
                Math.min(merge(a - 1, b + 1, c - 1), merge(a - 1, b - 1, c + 1)));

        return mem[a][b][c];
    }

    public int solution(String S) {
        // write your code in Java SE 8

        int a = 0, b = 0, c = 0;

        for (int i = 0; i < S.length(); i++) {
            char x = S.charAt(i);

            if (x == 'a') {
                a++;
            } else if (x == 'b') {
                b++;
            } else {
                c++;
            }
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    mem[i][j][k] = -1;
                }
            }
        }

        return merge(a, b, c);

    }

    public int solutionMath(String S) {

        int[] counts = new int[3];

        for (int i = 0; i < S.length(); i++) {
            char x = S.charAt(i);

            int x1 = (int) x - (int) 'a';

            counts[x1]++;
        }

        if (counts[0] == S.length() || counts[1] == S.length() || counts[2] == S.length()) {
            return S.length();
        }

        if (counts[0] % 2 == 0 & counts[1] % 2 == 0 && counts[2] % 2 == 0) {
            return 2;
        }

        if (counts[0] % 2 != 0 & counts[1] % 2 != 0 && counts[2] % 2 != 0) {
            return 2;
        }

        return 1;
    }
}
