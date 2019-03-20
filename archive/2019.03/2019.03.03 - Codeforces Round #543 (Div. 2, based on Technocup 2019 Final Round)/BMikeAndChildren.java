package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BMikeAndChildren {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    int G[] = new int[1 << 20];

    for (int i = 0; i < n; ++i) for (int j = i + 1; j < n; ++j) G[seq[i] + seq[j]]++;

    int ans = 0;
    for (int i = 0; i < G.length; ++i) ans = Math.max(ans, G[i]);

    out.printLine(ans);
  }
}
