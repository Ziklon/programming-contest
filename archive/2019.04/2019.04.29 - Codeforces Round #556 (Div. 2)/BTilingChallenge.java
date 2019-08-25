package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BTilingChallenge {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();

        char[][] grid = new char[n][];
        for (int i = 0; i < n; ++i) grid[i] = in.readString().toCharArray();

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '#') continue;

                int m = 0;
                for (int k = 0; k < 4; ++k) {
                    int x1 = dx[k] + i;
                    int y1 = dy[k] + j;
                    if (Math.max(x1, y1) < n && Math.min(x1, y1) >= 0 && grid[x1][y1] == '.') {
                        m++;
                    }
                }
                if (m == 4) {
                    grid[i][j] = '#';
                    for (int k = 0; k < 4; ++k) {
                        int x1 = dx[k] + i;
                        int y1 = dy[k] + j;
                        grid[x1][y1] = '#';
                    }
                }
            }

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] != '#') {
                    out.printLine("NO");
                    return;
                }
        out.printLine("YES");


    }
}
