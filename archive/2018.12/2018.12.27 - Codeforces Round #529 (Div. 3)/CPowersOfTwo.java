package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CPowersOfTwo {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();
    if (!isAble(n, k) || k > n) {
      out.printLine("NO");
      return;
    }
    out.printLine("YES");
    for (int i = 0; i < 31; ) {
      if (isAble(n - (1 << i), k - 1)) {
        out.print((1 << i) + " ");
        n -= (1 << i);
        k--;
      } else i++;
    }
  }

  boolean isAble(int n, int k) {
    int min = Integer.bitCount(n);
    return min <= k;
  }
}
