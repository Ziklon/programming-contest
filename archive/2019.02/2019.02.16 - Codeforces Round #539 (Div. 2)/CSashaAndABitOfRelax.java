package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CSashaAndABitOfRelax {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    int xor = 0;
    long ans = 0;
    int[][] counter = new int[2][1 << 20];

    counter[1][0] = 1;
    for (int i = 0; i < n; ++i) {
      xor ^= seq[i];
      ans += counter[i & 1][xor];
      counter[i & 1][xor]++;
    }

    out.printLine(ans);
  }
}
