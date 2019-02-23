package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class HGrid1 {
  static final int MOD = (int) (1e9 + 7);

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int h = in.readInt(), w = in.readInt();
    char[][] g = new char[h][];
    for (int i = 0; i < h; ++i) g[i] = in.readCharArray(w);
    int dp[][] = new int[h + 1][w + 1];
    dp[1][1] = 1;
    for (int i = 1; i <= h; ++i)
      for (int j = 1; j <= w; ++j) {
        if (g[i - 1][j - 1] == '.') {
          dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
          dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
        }
      }

    out.printLine(dp[h][w]);
  }
}
