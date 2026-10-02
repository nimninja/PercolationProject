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
        if (row <= 0 || row > n || col <= 0 || col > n) {throw new IllegalArgumentException();}
        boolArr[index] = true;

        if (row == 1) {uf.union(0,index);}

        if (row == n) {uf.union(n*n+1,index);}

        if (row > 1 && boolArr[index - n]) {uf.union(index,index-n);}

        if (row < n && boolArr[index + n]) {uf.union(index,index+n);}

        if (col > 1 && boolArr[index -1]) {uf.union(index,index-1);}

        if (col < n && boolArr[index + 1]) {uf.union(index,index+1);}

    }

    public boolean isOpen(int row, int col) {
        int index = (row-1) * n + col;
        if (row <= 0 || row > n || col <= 0 || col > n) {throw new IllegalArgumentException();}
        return boolArr[index];
    }

    public boolean isFull(int row, int col) {
        int index = (row-1) * n + col;
        if (row <= 0 || row > n || col <= 0 || col > n) {throw new IllegalArgumentException();}
        return boolArr[index] && uf.find(index) == uf.find(0);
    }

    public int numberOfOpenSites() {
        int count = 0;
        for (int i = 1; i < arr.length-1; i++) {
            if (boolArr[i] == true) {count++;}
        }
        return count;
    }

    public boolean percolates() {
        return uf.find(0) == uf.find(n*n+1);
    }


    //public static void main(String[] args) {

    //}
}
