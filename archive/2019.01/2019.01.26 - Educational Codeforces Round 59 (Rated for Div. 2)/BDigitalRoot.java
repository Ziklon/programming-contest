package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BDigitalRoot {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();

    for (int i = 0; i < n; ++i) {
      long m = in.readLong(), k = in.readInt();
      long ans = (m - 1) * 9;
      out.printLine(ans + k);
    }
  }
}
