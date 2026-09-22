import edu.princeton.cs.algs4.IndexFibonacciMinPQ;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private int[] arr;
    private Boolean[] boolArr;
    private WeightedQuickUnionUF uf;

    public Percolation(int n) {
        if (n <= 0) { throw new IllegalArgumentException("n must be greater than 0");}
        this.n = n;
        arr = new int[n*n+2];
        boolArr = new Boolean[n*n+2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            boolArr[i] = false;
        }
        uf = new WeightedQuickUnionUF(n*n+2);

    }

    public void open(int row, int col) throws IllegalArgumentException {

        int index = (row-1) * n + col;
        if (index <= 0 || index > arr.length) {throw new IllegalArgumentException();}
        boolArr[index] = true;

    }

    public boolean isOpen(int row, int col) {
        int index = (row-1) * n + col;
        if (index <= 0 || index > arr.length) {throw new IllegalArgumentException();}
        return boolArr[index];
    }

    public int numberOfOpenSites() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (boolArr[i] = true) {count++;}
        }
        return count;
    }


    //public static void main(String[] args) {

    //}
}
