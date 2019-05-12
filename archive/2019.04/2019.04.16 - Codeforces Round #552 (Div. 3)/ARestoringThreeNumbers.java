package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.Arrays;

public class ARestoringThreeNumbers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {


    long[] input = in.readLongArray(4);
    Arrays.sort(input);
    long a = input[0], b = input[1], c = input[2], d = input[3];

    long x3 = d - a;
    long x1 = b - x3;
    long x2 = c - x3;

    long[] ans1 = new long[] {x1, x2, x3};

    out.printLine(ans1);
  }
}
