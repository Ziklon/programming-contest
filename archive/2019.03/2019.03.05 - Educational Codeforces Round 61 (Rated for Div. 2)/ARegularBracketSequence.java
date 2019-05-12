package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class ARegularBracketSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int[] seq = in.readIntArray(4);

    if (seq[0] != seq[3]) {
      out.printLine("0");
    } else if (seq[2] > 0 && seq[0] == 0) {
      out.printLine("0");
    } else out.printLine("1");
  }
}
