package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class APointsInSegments {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt(), m = in.readInt();

    boolean vis[] = new boolean[m + 1];

    for (int i = 0; i < n; ++i) {
      int x = in.readInt(), y = in.readInt();
      for (int j = x; j <= y; ++j) vis[j] = true;
    }

    int count = 0;
    for (int i = 1; i <= m; ++i) if (!vis[i]) count++;

    out.printLine(count);
    for (int i = 1; i <= m; ++i) if (!vis[i]) out.print(i + " ");
  }
}
