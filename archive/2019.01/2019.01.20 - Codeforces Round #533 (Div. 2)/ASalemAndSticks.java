package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ASalemAndSticks {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    int[] seq = new int[n];
    for (int i = 0; i < n; ++i) seq[i] = in.readInt();

    int mini = 1 << 20, anst = -1;
    for (int t = 1; t <= 100; ++t) {
      int cost = 0;
      for (int item : seq) {
        if (item == t) continue;
        cost += Math.abs(item - t) - 1;
      }
      if (cost < mini) {
        mini = cost;
        anst = t;
      }
    }

    out.printLine(anst, mini);
  }
}
