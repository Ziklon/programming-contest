package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class ARomanAndBrowser {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();
    int seq[] = new int[n];
    boolean vis[] = new boolean[n];
    for (int i = 0; i < n; ++i) seq[i] = in.readInt();

    int ans = 0;
    for (int b = -n; b <= n; ++b) {

      Arrays.fill(vis, false);
      for (int i = -n; i <= n; ++i) {
        int c = b + (i * k);
        if (c >= 1 && c <= n) {
          vis[c - 1] = true;
        }
      }
      int x = 0, y = 0;
      for (int i = 0; i < n; ++i) {
        if (vis[i]) continue;
        if (seq[i] == 1) x++;
        else y++;
      }
      ans = Math.max(ans, Math.abs(x - y));
    }

    out.printLine(ans);
  }
}
