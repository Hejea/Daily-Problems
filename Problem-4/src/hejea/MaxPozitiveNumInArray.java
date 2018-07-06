package hejea;

public class MaxPozitiveNumInArray implements Execute {
    
    @Override
    public Integer execute(Integer[] array) {
        if (array.length == 0) return null;
        
        Integer sol;
        int i, untilIsNotPozitivNumber;
        
        untilIsNotPozitivNumber = 0;
        
        while (untilIsNotPozitivNumber < array.length && array[untilIsNotPozitivNumber] < 0) {
            untilIsNotPozitivNumber++;
        }
        
        sol = array[untilIsNotPozitivNumber];

        for (i = untilIsNotPozitivNumber + 1; i < array.length; i++) {
            if (array[i] < sol && array[i] > 0) sol = array[i];
        }

        for (i = untilIsNotPozitivNumber + 1; i < array.length; i++) {
            if (array[i] == sol + 1) sol = array[i];
        }
        
        return sol + 1;
    }
}
