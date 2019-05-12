package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ANekoFindsGrapes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();

    int[] a = new int[2];
    int[] b = new int[2];

    for (int i = 0; i < n; ++i) a[in.readInt() % 2]++;
    for (int i = 0; i < m; ++i) b[in.readInt() % 2]++;

    int ans = Math.min(a[0], b[1]) + Math.min(a[1], b[0]);

    out.printLine(ans);
  }
}
