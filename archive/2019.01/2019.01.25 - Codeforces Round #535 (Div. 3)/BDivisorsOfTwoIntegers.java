package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class BDivisorsOfTwoIntegers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] array = in.readIntArray(n);
    Arrays.sort(array);
    int[] counter = new int[1 << 20];
    int a1 = array[n - 1];

    for (int item : array) counter[item]++;
    int a2 = 0;
    for (int i = 1; i <= a1; ++i) {
      if (a1 % i == 0) counter[i]--;
      if (counter[i] > 0) a2 = i;
    }
    out.printLine(a1, a2);
  }
}
