package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ESuperheroBattle {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    long H = in.readLong();
    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    long sum = 0, mini = 0;

    for (int i = 0; i < n; ++i) {
      sum += seq[i];
      mini = Math.min(mini, sum);
      if (H + sum <= 0) {
        out.printLine(i + 1);
        return;
      }
    }
    if (sum >= 0) {
      out.printLine(-1);
      return;
    }

    long step = (H + mini - 1) / (-sum);
    long ans = step * n;

    H += step * sum;

    for (int i = 0; i < 3 * n; ++i) {
      H += seq[i % n];
      ans++;
      if (H <= 0) {
        out.printLine(ans);
        return;
      }
    }
  }
}
