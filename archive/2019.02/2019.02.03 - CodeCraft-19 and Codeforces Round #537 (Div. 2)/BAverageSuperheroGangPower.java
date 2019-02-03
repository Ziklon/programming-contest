package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.PriorityQueue;

public class BAverageSuperheroGangPower {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt(), m = in.readInt();
    int[] seq = in.readIntArray(n);
    ArrayUtils.sort(seq);

    long sum = 0;
    for (int i = 0; i < n; ++i) sum += seq[i];

    double ans = sum / (n * 1.0);

    for (int i = 0; i < n; ++i) {

      if (m > 0) {

        long add = Math.min(m, k * 1L * (n - i));
        ans = Math.max(ans, (sum + add + 0.0) / (n - i - 0.0));
        if (i + 1 < n) {
          m--;
          sum -= seq[i];
          add = Math.min(m, k * 1L * (n - i - 1L));
          ans = Math.max(ans, (sum + add + 0.0) / (n - i - 1.0));
        }
      }
    }

    out.printLine(String.format("%.12f", ans));
  }
}
