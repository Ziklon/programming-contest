package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CRamessesAndCornerInversion {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), m = in.readInt();

        int[][] a = in.readIntTable(n, m);
        int[][] b = in.readIntTable(n, m);

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                if (a[i][j] == b[i][j]) continue;
                if (i == n - 1 || j == m - 1) {
                    out.printLine("No");
                    return;
                }

                a[i][j] ^= 1;
                a[i][j + 1] ^= 1;
                a[i + 1][j] ^= 1;
                a[i + 1][j + 1] ^= 1;
            }

        out.printLine("Yes");

    }
}
