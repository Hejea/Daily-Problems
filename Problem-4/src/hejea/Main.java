package hejea;

public class Main {

    public static void main(String[] args) {
	    
        Integer[] a1 = {3, 4, -1, 1};
        Integer[] a2 = {1, 2, 0};
        Integer[] a3 = {-1, -2, 0, 4};
        Integer[] a4 = new Integer[0];
    
        MaxPozitiveNumInArray maxNumber = new MaxPozitiveNumInArray();
        Integer solution;
        
        solution = maxNumber.execute(a1);
        System.out.println("Solutino a1  = " + solution);
    
        solution = maxNumber.execute(a2);
        System.out.println("Solutino a2 = " + solution);
    
        solution = maxNumber.execute(a3);
        System.out.println("Solutino a3 = " + solution);
    
        solution = maxNumber.execute(a4);
        System.out.println("Solutino a4 = " + solution);
    }
}
