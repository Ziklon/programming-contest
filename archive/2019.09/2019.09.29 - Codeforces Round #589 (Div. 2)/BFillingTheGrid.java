package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;
import net.egork.numbers.IntegerUtils;

public class BFillingTheGrid {

    private final int MOD = (int) (1e9 + 7);


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int H = in.readInt(), W = in.readInt();

        int[] h = in.readIntArray(H);
        int[] w = in.readIntArray(W);

        int[][] table = new int[H][W];

        for (int j = 0; j < W; ++j) {
            int n = w[j];
            for (int i = 0; i < n; ++i) table[i][j] = 1;
        }
        for (int i = 0; i < H; ++i) {
            int n = h[i];
            for (int j = 0; j < n; ++j) table[i][j] = 1;
            int cnt = 0;
            for (int j = 0; j < W && table[i][j] == 1; ++j) cnt++;
            if (cnt != h[i]) {
                out.printLine(0);
                return;
            }
        }

        for (int j = 0; j < W; ++j) {
            int cnt = 0;
            for (int i = 0; i < H && table[i][j] == 1; ++i) cnt++;
            if (cnt != w[j]) {
                out.printLine(0);
                return;
            }
        }

        int ans = 0;
        for (int i = 0; i < H; ++i) {

            for (int j = h[i] + 1; j < W; ++j) {
                if (w[j] < i) ans++;
            }
        }

        out.printLine(IntegerUtils.power(2, ans, MOD));

    }
}
