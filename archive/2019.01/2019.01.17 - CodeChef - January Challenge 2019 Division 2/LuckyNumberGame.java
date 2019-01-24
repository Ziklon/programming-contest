package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class LuckyNumberGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int j = 0; j < t; ++j) {
      int n = in.readInt(), a = in.readInt(), b = in.readInt();

      int left = 0, right = 0, middle = 0;
      for (int i = 0; i < n; ++i) {
        long cur = in.readLong();
        if (cur % a == 0 && cur % b == 0) middle++;
        if (cur % a == 0) left++;
        if (cur % b == 0) right++;
      }
      if (middle > 0) left++;
      out.printLine(left > right ? "BOB" : "ALICE");
    }
  }
}
