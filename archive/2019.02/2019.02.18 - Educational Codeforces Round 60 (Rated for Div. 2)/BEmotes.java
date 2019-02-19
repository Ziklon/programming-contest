package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class BEmotes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt(), k = in.readInt();
    int[] seq = in.readIntArray(n);
    seq = ArrayUtils.sort(seq);

    long ans = 0;

    long times = m / (k + 1);
    long div = m % (k + 1);
    ans = times * seq[n - 1] * k;
    ans += times * seq[n - 2];
    ans += div * seq[n - 1];
    out.printLine(ans);
  }
}
