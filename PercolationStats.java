import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] res;


    public PercolationStats(int n, int trials) {
        if( n <= 0 || trials <= 0) {throw new IllegalArgumentException();}
        res = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation per = new Percolation(n);

            while (!per.percolates()) {
                int row = StdRandom.uniformInt(1,n+1);
                int col = StdRandom.uniformInt(1, n+1);

                per.open(row, col);
            }
            res[i] = (double) per.numberOfOpenSites() / (n*n);
        }

    }

    public double mean() {
        return StdStats.mean(res);
    }

    public double stddev() {
        return StdStats.stddev(res);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(res.length));
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(res.length));
    }


}