package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AGameShopping {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();
    int[] a = in.readIntArray(n);
    int[] b = in.readIntArray(m);

    int ans = 0;
    int idx = 0;
    for (int i = 0; i < n && idx < m; ++i) {
      if (a[i] <= b[idx]) {
        ans++;
        idx++;
      }
    }
    out.printLine(ans);
  }
}
