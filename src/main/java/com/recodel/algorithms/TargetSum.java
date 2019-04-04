package com.recodel.algorithms;

import java.util.HashMap;
import java.util.Map;

/*
    Problem: you have an function that takes an array of unique integers and a sum.
    Find the first pair of integers that would yield this sum
 */
public class TargetSum {
    public static void findIndices(int[] nums, int sum){
        Map<Integer, Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            int num = nums[i];
            int diff = sum - num;
            if(res.get(diff) != null){
                System.out.println("Found indices: " + res.get(diff) + "," + i);
                return;
            }
            else{
                res.put(num, i);
            }
        }
        System.out.println("Cannot find indices!");
    }

    public static void main(String[] args) {
        int[] nums_test_1 = {1,3,5,7,9,-10,4};
        int sum = 16;
        findIndices(nums_test_1, sum);

        int[] nums_test_2 = {12,3,5,7,9,10,-5,-8};
        sum = 21;
        findIndices(nums_test_2, sum);

        int[] nums_test_3 = {12,3,5,7,9,78};
        sum = 100;
        findIndices(nums_test_3, sum);
    }
}
