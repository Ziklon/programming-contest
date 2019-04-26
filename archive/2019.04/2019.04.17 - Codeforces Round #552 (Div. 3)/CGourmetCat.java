package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import sun.nio.cs.ext.MacArabic;

public class CGourmetCat {

  int[] type = {0, 1, 2, 0, 2, 1, 0};

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int a = in.readInt(), b = in.readInt(), c = in.readInt();

    long ans = 0;

    for (int start = 0; start < 7; ++start) {

      long low = 0, hih = 1L << 50;
      while (hih - low > 1) {
        long middle = (low + hih) >> 1;
        if (isPossible(middle, start, a, b, c)) low = middle;
        else hih = middle;
      }
      ans = Math.max(ans, low);
    }
    out.printLine(ans);
  }

  private boolean isPossible(long middle, int start, int a, int b, int c) {
    long[] need = new long[3];
    for (int i = 0; i < 7; ++i) {
      int id = type[(start + i) % 7];
      long v = (middle / 7) + ((middle % 7) > i ? 1 : 0);
      need[id] += v;
    }
    return need[0] <= a && need[1] <= b && need[2] <= c;
  }
}
