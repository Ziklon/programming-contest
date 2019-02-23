package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class MaxRangeQueries {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    final int SIZE = 100000;
    int t = in.readInt();
    for (int i = 0; i < t; ++i) {
      int n = in.readInt(), k = in.readInt();

      int[] counter = new int[SIZE + 5];
      int[] xs = new int[n];
      int[] ys = new int[n];
      for (int j = 0; j < n; ++j) {
        int x = in.readInt() - 1, y = in.readInt();
        xs[j] = x;
        ys[j] = y;
        counter[x]++;
        counter[y]--;
      }

      for (int j = 0; j + 1 < counter.length; ++j) {
        counter[j + 1] += counter[j];
      }

      int[] counterK = calculateCounterK(counter, k);
      int[] counterKPlus = calculateCounterK(counter, k + 1);

      int ans = 0;
      for (int j = 0; j < n; ++j) {
        int x = xs[j], y = ys[j];
        int tmp = count(counterKPlus, x, y);
        if (x > 0) tmp += count(counterK, 0, x - 1);
        tmp += count(counterK, y + 1, SIZE + 3);
        ans = Math.max(ans, tmp);
      }
      out.printLine(ans);
    }
  }

  int count(int[] prefix, int l, int r) {
    return prefix[r + 1] - prefix[l];
  }

  private int[] calculateCounterK(int[] values, int k) {
    int[] prefix = new int[values.length];
    for (int i = 0; i + 1 < values.length; ++i) {
      prefix[i + 1] = prefix[i] + (values[i] == k ? 1 : 0);
    }
    return prefix;
  }
}
