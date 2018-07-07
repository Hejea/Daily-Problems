package hejea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    
        
        List<Integer> sol;
        List<Integer> a1  = Arrays.asList(1, 2);
        List<Integer> a2 = new ArrayList<>();
        List<Integer> a3  = Arrays.asList(2, 4, 5, 7, 8, 9);
        List<Integer> a4  = null;
        List<Integer> a5  = Arrays.asList(1, 5, 8);
        List<Integer> a6 = new ArrayList<>();
        
        List<List<Integer>> all1 = Arrays.asList(a1, a2, a3, a4, a5, a6);
        List<List<Integer>> all2 = null;
        List<List<Integer>> all3 = new ArrayList<>();
        List<List<Integer>> all4 = Arrays.asList(a2, a4,  a6);
        List<List<Integer>> all5 = Arrays.asList(a1, a4, a3, a6);
        
    
    
        System.out.println(all1);
        System.out.println(all2);
        System.out.println(all3);
        System.out.println(all4);
        System.out.println(all5);
        
        MergeArray mergeArray = new MergeArray();
        
        sol = mergeArray.merge(all1);
    
        System.out.println("sol = " + sol);
        
    }
}
