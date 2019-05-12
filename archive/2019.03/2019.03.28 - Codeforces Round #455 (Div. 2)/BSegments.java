package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BSegments {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();

    int ans = ((n / 2) + 1) * ((n + 1) >> 1);

    out.printLine(ans);
  }
}
