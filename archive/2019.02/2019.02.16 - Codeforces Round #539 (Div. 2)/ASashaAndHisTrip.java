package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ASashaAndHisTrip {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();

    int gas = Math.min(m, n - 1);
    int cost = gas;

    if (gas + 1 == n) {
      out.printLine(cost);
      return;
    }
    for (int i = 2; i < n; ++i) {
      gas--;
      if (gas + i == n) break;
      gas++;
      cost += i;
    }

    out.printLine(cost);
  }
}
