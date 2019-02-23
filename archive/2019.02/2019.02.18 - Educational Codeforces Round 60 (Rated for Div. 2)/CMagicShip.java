package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class CMagicShip {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x1 = in.readInt(), y1 = in.readInt();
    int x2 = in.readInt(), y2 = in.readInt();
    int n = in.readInt();
    String s = in.readString();
    long[][] prefix = new long[n + 1][];
    prefix[0] = new long[] {0, 0};

    for (int i = 0; i < n; ++i) {
      prefix[i + 1] = Arrays.copyOf(prefix[i], 2);
      if (s.charAt(i) == 'U') prefix[i + 1][0]++;
      else if (s.charAt(i) == 'D') prefix[i + 1][0]--;
      else if (s.charAt(i) == 'L') prefix[i + 1][1]--;
      else if (s.charAt(i) == 'R') prefix[i + 1][1]++;
    }
    long low = 0, hih = (long) 1e1;
    while (low < hih) {
      long mid = (hih + low) >> 1;

      long xi = x1 + (prefix[n][1] * (mid / n)) + prefix[(int) (mid % n)][1];
      long yi = y1 + (prefix[n][0] * (mid / n)) + prefix[(int) (mid % n)][0];

      if (Math.abs(x2 - xi) + Math.abs(y2 - yi) <= mid) {
        hih = mid;
      } else low = mid + 1;
    }
    if (hih > (long) 1e17) out.printLine(-1);
    else out.printLine(low);
  }
}
