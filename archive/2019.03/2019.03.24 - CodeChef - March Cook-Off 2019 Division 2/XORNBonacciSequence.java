package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class XORNBonacciSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt(), q = in.readInt();
    int[] seq = in.readIntArray(n);

    int fn = 0;
    for (int e : seq) fn ^= e;
    seq = ArrayUtils.concatenate(seq, new int[] {fn});

    int sx[] = new int[n + 1];

    for (int i = 0; i < sx.length; ++i) {
      sx[i] ^= seq[i % (n + 1)];
      if (i > 0) sx[i] ^= sx[i - 1];
    }
    for (int i = 0; i < q; ++i) {
      int x = (in.readInt() - 1) % (n + 1);
      out.printLine(sx[x]);
    }
  }
}
