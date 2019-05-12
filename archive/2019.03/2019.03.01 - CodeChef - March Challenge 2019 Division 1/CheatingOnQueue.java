package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CheatingOnQueue {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int j = 0; j < t; ++j) {
      int n = in.readInt(), k = in.readInt();
      int[] seq = in.readIntArray(n);

      int low = -1, hih = n;
      while (hih - low > 1) {
        int middle = (low + hih) >> 1;
        if (isPossible(middle, seq, k)) hih = middle;
        else low = middle;
      }
      out.printLine(hih + 1);
    }
  }

  private boolean isPossible(int idx, int[] seq, long k) {

    long sum = 0;
    for (int i = idx; i < seq.length; ++i) {
      sum += seq[i] / (i + 1);
    }
    return sum <= k;
  }
}
