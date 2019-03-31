package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class AEquality {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();
    String s = in.readString();

    int[] counter = new int[k];
    for (char c : s.toCharArray()) counter[c - 'A']++;

    Arrays.sort(counter);

    out.printLine(counter[0] * k);
  }
}
