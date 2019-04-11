package com.recodel.algorithms;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class FreqQuery {


    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> m = new Hashtable<>();
        for(List<Integer> query : queries){
            int operation = query.get(0);
            int n = query.get(1);
            switch(operation){
                case 1:
                    int cnt = m.containsKey(n) ? m.get(n) + 1: 1;
                    m.put(n, cnt);
                    break;
                case 2:
                    if(m.containsKey(n)){
                        if(m.get(n) == 1) {
                            m.remove(n);
                        }
                        else {
                            m.put(n, m.get(n) - 1);
                        }
                    }
                    break;
                case 3:
                    cnt = m.containsValue(n) ? 1 : 0; // not an optimal solution since this lookup is O(n), python version is more efficient & cleaner
                    res.add(cnt);
                    break;
                default:
                    System.out.println("Unrecognized operation: " + operation);
            }
        }
        return res;
    }
    public static void main(String[] args){
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);

    }

}
