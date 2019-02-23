package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BCreatingTheContest {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    int ans = 1;
    int cnt = 1;
    for (int i = 1; i < n; ++i) {
      if (seq[i - 1] * 2 >= seq[i]) cnt++;
      else {
        cnt = 1;
      }
      ans = Math.max(ans, cnt);
    }

    out.printLine(ans);
  }
}
