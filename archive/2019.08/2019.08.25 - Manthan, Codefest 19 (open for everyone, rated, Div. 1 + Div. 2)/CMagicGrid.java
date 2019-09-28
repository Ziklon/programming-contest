package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CMagicGrid {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();
        int[][] grid = new int[n][n];

        int x = 0;
        for (int i = 0; i < n; i = i + 4)
            for (int j = 0; j < n; j = j + 4)
                for (int ii = 0; ii < 4; ++ii)
                    for (int jj = 0; jj < 4; ++jj)
                        grid[i + ii][j + jj] = x++;


        for (int[] row : grid) out.printLine(row);


    }
}
