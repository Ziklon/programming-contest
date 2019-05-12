package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class CAlarmClocksEverywhere {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt(), m = in.readInt();

    long gcd = 0;

    long[] seq = in.readLongArray(n);

    for (int i = 0; i + 1 < n; ++i) {
      gcd = IntegerUtils.gcd(gcd, seq[i + 1] - seq[i]);
    }

    int at = -1;
    for (int i = 0; i < m; ++i) {
      long x = in.readLong();
      if (gcd % x == 0) {
        at = i + 1;
        break;
      }
    }
    if (at == -1) out.printLine("NO");
    else {
      out.printLine("YES");
      out.printLine(new long[] {seq[0], at});
    }
  }
}
