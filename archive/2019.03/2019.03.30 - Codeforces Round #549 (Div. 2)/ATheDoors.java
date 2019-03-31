package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ATheDoors {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    int seq[] = in.readIntArray(n);

    int next = seq[n - 1] ^ 1;

    for (int i = n - 1; i >= 0; --i)
      if (seq[i] == next) {
        out.printLine(i + 1);
        return;
      }
  }
}
