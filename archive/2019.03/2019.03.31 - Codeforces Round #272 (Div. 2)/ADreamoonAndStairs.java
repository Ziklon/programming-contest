package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ADreamoonAndStairs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();

    int moves = Integer.MAX_VALUE;

    for (int i = 0; i <= n; i++) {
      int p = i + (n - (i * 2));
      if (i * 2 <= n && p % m == 0) {
        moves = Math.min(moves, p);
      }
    }
    out.printLine(moves == Integer.MAX_VALUE ? -1 : moves);
  }
}
