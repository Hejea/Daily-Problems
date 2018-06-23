package hejea;

public class Main {

    public static void main(String[] args) {
        
        Solution solution = new Solution();
        Solution.VisualSolution b;
        
        b = solution.giveSolution(Solution.giveRandomArray(12, 0, 117), 55);
        
        System.out.println("\nSolution is : " + b);
    }
}
