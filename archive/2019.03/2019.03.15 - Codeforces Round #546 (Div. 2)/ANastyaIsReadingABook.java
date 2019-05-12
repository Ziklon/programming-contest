package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ANastyaIsReadingABook {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int left[] = new int[n], right[] = new int[n];
    in.readIntArrays(left, right);
    int k = in.readInt();

    int ans = 0;
    for (int i = 0; i < n; ++i) {
      if (k <= right[i]) ans++;
    }
    out.printLine(ans);
  }
}
