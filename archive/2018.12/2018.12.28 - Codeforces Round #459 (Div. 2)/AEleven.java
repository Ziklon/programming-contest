package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class AEleven {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] f = new int[30];
    f[1] = f[2] = 1;
    for (int i = 3; i < f.length; ++i) f[i] = f[i - 1] + f[i - 2];

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; ++i) {
      if (Arrays.binarySearch(f, i) >= 0) sb.append('O');
      else sb.append('o');
    }
    out.printLine(sb);
  }
}
