package hejea;

import java.util.ArrayList;
import java.util.List;

public class MergeArray {
    
    // from a List with many kind of lists,
    // gives a single merged list
    // complexity
    // O(n1) + O(n2) + O( 2 * log(n2) + n3 - n2 )
    public List<Integer> merge(List<List<Integer>> arrayLists) {
        
        // if array lists doesn't exist
        if (arrayLists == null) return null;
        
        
        // if array lists is empty (but exists)
        List<Integer> solution = new ArrayList<>();
        if (arrayLists.size() == 0) return solution;
        
        
        // local variables
        //  i           - just an iterator
        //  validLists  - lists that are not empty or null
        //  iIndex      - is the index of head index in array of index
        int                 i, iIndex;
        List<List<Integer>> validLists = new ArrayList<>();
        
        
        // looking for not null or not empty lists
        // O(n1) - n1 = how many lists do you have
        for (List<Integer> list : arrayLists)
            if (list != null && !list.isEmpty())
                validLists.add(list);
        
        
        // if not found lists return an empty list
        if (validLists.size() == 0) return solution;
        
        
        // local variables
        //  index    - and an array that contain the index of head from each list
        //  heads    - a list where a store all head value
        //  cMinHead - the current minimal head
        int[]        index = new int[validLists.size()];
        List<Bubble> heads = new ArrayList<>();
        Bubble       cMinHead;
        
        
        // store 1-sts value from each list as heads,
        // for further on to find Min head as a solution
        // O(n2) - n2 = how many valid lists do you have
        for (i = 0; i < validLists.size(); i++)
            heads.add(Bubble.getBubble(validLists.get(i).get(0), i));
        
        
        // until exists head,
        // find minimal head,
        // store it as a solution,
        // from what list you took the head,
        // add next value as a head, if it exist
        // and delete the current minimal head from heads list
        // O( 2 * log(n2) + n3 - n2 ) - n2 = how many valid lists do you have
        //                                 "lists can be longer or shorter"
        //                                 "if a list reach its end, it is not further touched"
        //                            - n3 = how many value do you have in all lists
        //                                 "if and value is found, it is not further touched"
        while (!heads.isEmpty()) {
            cMinHead = getMinimalHead(heads);
            iIndex = heads.get(cMinHead.pos).pos;
            
            solution.add(cMinHead.min);
            
            heads.remove(cMinHead.pos);
            index[iIndex]++;
            
            try {
                heads.add(Bubble.getBubble(validLists.get(iIndex).get(index[iIndex]), iIndex));
            } catch (Exception ignored) {
            }
        }
        
        return solution;
    }
    
    // from a list of values gives minimal value,
    // if there are 2 minimal value gives that one that has lowest index
    // O(n) - n = list size
    private Bubble getMinimalHead(List<Bubble> heads) {
        
        int    i      = 0, pos;
        Bubble rezult = new Bubble();
        pos = 0;
        rezult.min = heads.get(0).min;
        rezult.pos = heads.get(0).pos;
        while (i < heads.size()) {
            Bubble current = heads.get(i);
            if (rezult.min > current.min ||
                (rezult.min.intValue() == current.min.intValue() &&
                 rezult.pos > current.pos)) {
                rezult.min = current.min;
                rezult.pos = current.pos;
                pos = i;
            }
            i++;
        }
        rezult.pos = pos;
        return rezult;
    }
    
    
    // shows an array of integers on the screen
    private String showArray(int[] a) {
        StringBuilder s = new StringBuilder("[");
        for (int anA : a) {
            s.append(" ").append(anA);
        }
        s.append(" ]");
        return s.toString();
    }
    
    
    // shows a list on the screen
    private String showBubble(List<Bubble> bubbles) {
        StringBuilder s = new StringBuilder("[");
        for (Bubble a : bubbles) {
            s.append(" {").append(a.min).append(", ").append(a.pos).append("}");
        }
        s.append(" ]");
        return s.toString();
    }
    
    // reprezent a cuple of data, with which is stored
    // the minimal head value, and the index of its list
    // and a function that makes bubbles
    private static class Bubble {
        Integer min;
        int     pos;
        
        static Bubble getBubble(Integer num, int pos) {
            Bubble b = new Bubble();
            b.min = num;
            b.pos = pos;
            return b;
        }
    }
}
