package com.tushar.dsa.strings.all_unique_substrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/letter-tile-possibilities/
public class Solution {

    int count = 0;
    private void possibilitiesKeepingOneConstant(char[] chArr, boolean[] fixed){

//        Set<Character> chUsed = new HashSet<>();

        for(int i=0; i< chArr.length; i++){
            if(fixed[i] /*|| chUsed.contains(chArr[i])*/){
                continue;
            }
            fixed[i] = true;
            count++;
            possibilitiesKeepingOneConstant(chArr, fixed);
            fixed[i] = false;

//            chUsed.add(chArr[i]);

            // skip other matching elements.
            while(i< chArr.length-1 && chArr[i] == chArr[i+1]){
                i++;
            }
        }
    }

    public int numTilePossibilities(String tiles) {

        if (tiles == null || tiles.length() == 0){
            return 0;
        }

        char[] chArr = tiles.toCharArray();

        boolean[] fixed = new boolean[tiles.length()];
        Arrays.sort(chArr);

        possibilitiesKeepingOneConstant(chArr, fixed);

        return count;
    }
}
