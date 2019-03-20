package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AGame23 {
  int inf = 1 << 20;

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int a = in.readInt(), b = in.readInt();
    int ans = func(a, b);
    if (ans >= inf) out.printLine(-1);
    else out.printLine(ans);
  }

  int func(int a, int b) {
    if (a == b) return 0;

    int ans = inf;
    if (a * 2 <= b) ans = Math.min(ans, func(a * 2, b) + 1);
    if (a * 3 <= b) ans = Math.min(ans, func(a * 3, b) + 1);
    return ans;
  }
}
