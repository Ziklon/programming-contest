package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class EPolycarpsNewJob {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();

    int wx = 0;
    int wy = 0;

    for (int t = 0; t < n; ++t) {
      char c = in.readCharacter();
      int x = in.readInt(), y = in.readInt();
      int xx = Math.min(x, y);
      int yy = Math.max(x, y);
      if (c == '+') {
        wx = Math.max(xx, wx);
        wy = Math.max(yy, wy);
      } else {
        if (xx >= wx && yy >= wy) out.printLine("YES");
        else out.printLine("NO");
      }
    }
  }
}
