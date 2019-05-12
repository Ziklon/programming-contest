package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Deque;

public class C1IncreasingSubsequenceEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    int low = 0, hih = n - 1;

    StringBuilder sb = new StringBuilder();
    int current = 0;
    while (hih >= low) {
      int mini = Math.min(seq[low], seq[hih]);
      int max = Math.max(seq[low], seq[hih]);

      if (max < current) break;
      if (low == hih) {
        sb.append("R");
        break;
      }
      int which = 0;

      if (current < mini) which = mini;
      else which = max;
      if (seq[low] == which) {
        sb.append("L");
        low++;
      } else {
        sb.append("R");
        hih--;
      }
      current = which;
    }

    out.printLine(sb.length());
    out.printLine(sb.toString());
  }
}
