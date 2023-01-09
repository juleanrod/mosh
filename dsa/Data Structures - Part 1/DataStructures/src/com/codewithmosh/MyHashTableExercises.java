package com.codewithmosh;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class MyHashTableExercises {
    
    public static int mostFrequent(int[] array) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i]))
                map.put(array[i], 1);
            map.put(array[i], map.get(array[i]) + 1);
        }

        int freq = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > freq)
                freq = entry.getKey();
        }

        return freq;
    }

    public static int countPairsWithDiff(int[] array, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++) {
            if(!hm.containsKey(array[i]))
                hm.put(array[i], 0);
            if(hm.containsKey(array[i] - k))
                hm.put(array[i], hm.get(array[i]) + 1);
        }

        int pairsCount = 0;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            pairsCount += entry.getValue();
        }
        return pairsCount;
    }

    public static int[] twoSum(int[] array, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if(map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(array[i], i);
        }

        return array;
    }
}
