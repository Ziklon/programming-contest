package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;
import net.egork.misc.MiscUtils;

public class DJongmah {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    int[] seq = in.readIntArray(n);

    int[] counter = new int[m + 1];
    for (int e : seq) counter[e]++;

    int[][] dp = new int[3][3];

    for (int c : counter) {
      int[][] next = new int[3][3];
      for (int x = 0; x < 3; ++x) {
        for (int y = 0; y < 3; ++y) {
          for (int z = 0; z < 3; ++z) {
            if (x + y + z <= c) {
              next[y][z] = Math.max(next[y][z], dp[x][y] + z + (c - x - y - z) / 3);
            }
          }
        }
      }
      dp = next;
    }

    out.printLine(dp[0][0]);
  }
}
