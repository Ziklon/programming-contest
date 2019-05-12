package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int a = in.readInt(), b = in.readInt();
    int ans = ((a + 1) / 2) + (b + 1) / 2;


    out.printLine(String.format("Case #%d: %d", testNumber, ans));
  }
}
