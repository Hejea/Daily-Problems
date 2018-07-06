package hejea;

import java.util.*;

public class Solution {
    
    public static void showArray (int[] array) {
        System.out.println("\nVector :");
        for (Integer a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
    
    public void showSolution (List<Integer> array) {
        
        int i, j, n;
        n = array.size();
        
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        
        a1[0] = a2[0] = 1;
        a1[1] = array.get(0);
        a2[1] = array.get(n -1);
        
        for (i = 2, j = n - 2; i < n; i++, j--) {
            a1[i] = a1[i - 1] * array.get(i-1);
            a2[i] = a2[i - 1] * array.get(j);
        }
        
        for (i = 0; i < n; i++) a1[i] = a1[i] * a2[n - 1 - i];
        
        showArray(a1);
    }
}
