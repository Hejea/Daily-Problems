package hejea;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Solution {
    
    public static List<Integer> giveRandomArray (int nElem, int min, int max) {
        List<Integer> vector = new ArrayList<>();
        Random rand = new Random();
        
        for (int i = 0; i < nElem; i++)
            vector.add(rand.nextInt(max - min + 1) + min );
    
        showArray(vector);
    
        return vector;
    }
    
    public static void showArray (List<Integer> vector) {
        System.out.println("\nVector :");
        for (Integer a : vector) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
    
    public VisualSolution giveSolution (List<Integer> vector, int k) {
        
        VisualSolution vs = new VisualSolution();
        
        vector.sort(Comparator.naturalOrder());
        
        showArray(vector);
        
        int i, j, z;
        i = 0;
        j = vector.size() - 1;
        
        while (i <= j) {
            vs.l = vector.get(i);
            vs.r = vector.get(j);
            
            z = vs.l + vs.r;

            if (z == k) {
                vs.b = true;
                return vs;
            }
            if (z < k) i++;
            if (z > k) j--;
        }
    
        vs.l = vs.r = -1;
        
        return vs;
    }
    
    public class VisualSolution {
        boolean b = false;
        int l = -1;
        int r = -1;
    
        @Override
        public String toString() {
            return b + "( " + l + ", " + r + " )";
        }
    }
    
}
