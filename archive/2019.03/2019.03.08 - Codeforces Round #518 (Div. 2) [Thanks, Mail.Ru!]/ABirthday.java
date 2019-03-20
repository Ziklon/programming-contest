package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ABirthday {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long N = in.readLong(), M = in.readLong(), K = in.readLong(), L = in.readLong();

    long ans = ((L + K) - 1) / M + 1;
    if (ans * M > N || ans * M - K < L) out.printLine(-1);
    else out.printLine(ans);
  }
}
