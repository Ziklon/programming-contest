package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ACoins {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt(), m = in.readInt();

    int ans = 0;
    while (m > 0) {
      while (m >= n) {
        ans++;
        m -= n;
      }
      n--;
    }
    out.printLine(ans);
  }
}
