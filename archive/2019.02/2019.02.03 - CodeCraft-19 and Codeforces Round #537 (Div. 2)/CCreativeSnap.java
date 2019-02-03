package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class CCreativeSnap {

  long func(int[] seq, int low, int hih, int A, int B) {

    int na = ArrayUtils.lowerBound(seq, hih) - ArrayUtils.lowerBound(seq, low);
    if (na == 0) return A;
    else {
      int len = hih - low;
      long ans = na * 1L * len * B;
      if (len == 1) return ans;
      int mid = (low + hih) >> 1;
      ans = Math.min(ans, func(seq, low, mid, A, B) + func(seq, mid, hih, A, B));
      return ans;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt(), A = in.readInt(), B = in.readInt();
    int[] seq = in.readIntArray(k);
    seq = ArrayUtils.radixSort(seq);
    for (int i = 0; i < k; ++i) seq[i] += -1;
    out.printLine(func(seq, 0, (1 << n), A, B));
  }
}
