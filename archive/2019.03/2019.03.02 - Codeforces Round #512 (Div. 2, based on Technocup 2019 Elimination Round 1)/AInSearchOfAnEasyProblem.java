package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AInSearchOfAnEasyProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    boolean ans = true;
    for (int e : seq) if (e > 0) ans = false;

    out.printLine(!ans ? "HARD" : "EASY");
  }
}
