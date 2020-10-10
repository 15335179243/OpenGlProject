package com.chumu.openglproject;

import java.util.HashMap;
import java.util.Map;

/**
 * OpenGlProject
 * <p>
 * Created by ChuMu on 2020/10/10
 * Copyright © 2020年 ChuMu. All rights reserved.
 * <p>
 * Describe:
 */

public class Test {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 6);
        System.out.println(ints[0]+"+++"+ints[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
